package com.coiggahou.catplatform.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coiggahou.catplatform.dto.CatDTO;
import com.coiggahou.catplatform.dto.CheckRecordDTO;
import com.coiggahou.catplatform.dto.FeedRecordDTO;
import com.coiggahou.catplatform.entity.*;
import com.coiggahou.catplatform.entity.Character;
import com.coiggahou.catplatform.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CatMapper catMapper;

    @Autowired
    private FeedRecordMapper feedRecordMapper;

    @Autowired
    private CheckRecordMapper checkRecordMapper;

    @Autowired
    private CatTypeMapper catTypeMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private ColorMapper colorMapper;


    @Override
    public List<CatDTO> listAll() {
        List<Cat> cats = catMapper.selectList(new QueryWrapper<>());
        List<CatDTO> dtos = new ArrayList<>();
        for (Cat cat : cats) {
            CatType type = catTypeMapper.selectById(cat.getTypeId());
            Location location = locationMapper.selectById(cat.getAroundLocationId());
            Character character = characterMapper.selectById(cat.getCharacterId());
            Color color = colorMapper.selectById(cat.getColorId());
            dtos.add(new CatDTO(
                    cat.getId(),
                    cat.getName(),
                    type,
                    color,
                    character,
                    location
            ));
        }
        return dtos;
    }

    @Override
    public boolean updateCat(Cat cat) {
        catMapper.updateById(cat);
        return true;
    }

    @Override
    public boolean addCat(Cat cat) {
        catMapper.insert(cat);
        return true;
    }

    @Override
    public boolean removeCatById(String id) {
        catMapper.deleteById(id);
        return true;
    }

    @Override
    public CatDTO getById(String id) {
        Cat cat = catMapper.selectById(id);
        if (cat == null) return null;
        CatType type = catTypeMapper.selectById(cat.getTypeId());
        Location location = locationMapper.selectById(cat.getAroundLocationId());
        Character character = characterMapper.selectById(cat.getCharacterId());
        Color color = colorMapper.selectById(cat.getColorId());
        return new CatDTO(
                cat.getId(),
                cat.getName(),
                type,
                color,
                character,
                location
        );
    }

    @Override
    public List<Color> listAllColors() {
        return colorMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Character> listAllCharacters() {
        return characterMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<CatType> listAllCatTypes() {
        return catTypeMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Food> listAllFoods() {
        return foodMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Location> listAllLocations() {
        return locationMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 猫猫出现位置打卡
     */
    @Override
    public boolean check(CheckRecord checkRecord) {
        checkRecordMapper.insert(checkRecord);
        return true;
    }

    @Override
    public List<CheckRecordDTO> listAllCheckRecords() {
        List<CheckRecord> checkRecords = checkRecordMapper.selectList(new QueryWrapper<>());
        List<CheckRecordDTO> dtos = new ArrayList<>();
        for (CheckRecord record : checkRecords) {
            dtos.add(
                    new CheckRecordDTO(
                            record.getId(),
                            locationMapper.selectById(record.getLocationId()),
                            record.getTime(),
                            catMapper.selectById(record.getCatId())
                    )
            );
        }
        return dtos;
    }

    /**
     * 投喂登记
     */
    @Override
    public boolean feed(FeedRecord feedRecord) {
        feedRecordMapper.insert(feedRecord);
        return true;
    }

    @Override
    public List<FeedRecordDTO> listAllFeedRecords() {
        List<FeedRecord> feedRecords = feedRecordMapper.selectList(new QueryWrapper<>());
        List<FeedRecordDTO> dtos = new ArrayList<>();
        for (FeedRecord record : feedRecords) {
            User user = userMapper.selectById(record.getUserId());
            String username = user.getUsername();
            dtos.add(
                    new FeedRecordDTO(
                            record.getId(),
                            username,
                            record.getTime(),
                            locationMapper.selectById(record.getLocationId()),
                            catMapper.selectById(record.getCatId()),
                            foodMapper.selectById(record.getFoodId())
                    )
            );
        }
        return dtos;
    }
}
