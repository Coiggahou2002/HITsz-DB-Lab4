package com.coiggahou.catplatform.service;

import com.coiggahou.catplatform.dto.CatDTO;
import com.coiggahou.catplatform.dto.CheckRecordDTO;
import com.coiggahou.catplatform.dto.FeedRecordDTO;
import com.coiggahou.catplatform.entity.*;
import com.coiggahou.catplatform.entity.Character;

import java.util.List;

/**
 * @author coiggahou
 */
public interface CatService {
    List<CatDTO> listAll();

    boolean updateCat(Cat cat);

    boolean addCat(Cat cat);

    boolean removeCatById(String id);

    CatDTO getById(String id);

    /**
     * 获取所有颜色
     */
    List<Color> listAllColors();

    /**
     * 获取所有性格
     */
    List<Character> listAllCharacters();

    /**
     * 获取所有猫品种
     */
    List<CatType> listAllCatTypes();

    /**
     * 获取所有食物
     */
    List<Food> listAllFoods();

    /**
     * 获取所有地点
     */
    List<Location> listAllLocations();

    /**
     * 签到
     */
    boolean check(CheckRecord checkRecord);

    /**
     * 获取所有猫猫打卡记录
     */
    List<CheckRecordDTO> listAllCheckRecords();


    /**
     * 投喂登记
     */
    boolean feed(FeedRecord feedRecord);

    /**
     * 获取所有投喂记录
     */
    List<FeedRecordDTO> listAllFeedRecords();

}
