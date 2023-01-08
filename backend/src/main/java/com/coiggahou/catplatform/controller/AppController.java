package com.coiggahou.catplatform.controller;

import com.coiggahou.catplatform.dto.CheckRecordDTO;
import com.coiggahou.catplatform.dto.FeedRecordDTO;
import com.coiggahou.catplatform.entity.*;
import com.coiggahou.catplatform.entity.Character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.coiggahou.catplatform.dto.CatDTO;
import com.coiggahou.catplatform.service.CatService;
import com.coiggahou.catplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags="所有API")
public class AppController {

    @Autowired
    private CatService catService;

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("user_login")
    public ApiResponse userLogin(@RequestBody User user) {
        return userService.login(user);
    }

    @ApiOperation("用户注册")
    @PostMapping("user_register")
    public ApiResponse userRegister(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation("获得所有猫的信息")
    @GetMapping("list_all_cats")
    public List<CatDTO> listAllCats() {
        return catService.listAll();
    }

    @ApiOperation("更新指定猫的信息")
    @PostMapping("update_cat")
    public boolean updateCat(@RequestBody Cat cat) {
        return catService.updateCat(cat);
    }

    @ApiOperation("添加单只猫信息")
    @PostMapping("add_cat")
    public boolean addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @ApiOperation("根据id删除指定猫信息")
    @PostMapping("remove_cat_by_id")
    public boolean removeCatById(@RequestParam String id) {
        return catService.removeCatById(id);
    }

    @ApiOperation("根据id获取指定猫信息")
    @GetMapping("get_cat_by_id")
    public CatDTO getCatById(@RequestParam String id) {
        return catService.getById(id);
    }

    @ApiOperation("获取所有颜色")
    @GetMapping("list_all_colors")
    public List<Color> listAllColors() {
        return catService.listAllColors();
    }

    @ApiOperation("获取所有性格")
    @GetMapping("list_all_characters")
    public List<Character> listAllCharacters() {
        return catService.listAllCharacters();
    }

    @ApiOperation("获取所有猫品种")
    @GetMapping("list_all_cat_types")
    public List<CatType> listAllCatTypes() {
        return catService.listAllCatTypes();
    }

    @ApiOperation("获取所有食物")
    @GetMapping("list_all_foods")
    public List<Food> listAllFoods() {
        return catService.listAllFoods();
    }

    @ApiOperation("获取所有地点")
    @GetMapping("list_all_locations")
    public List<Location> listAllLocations() {
        return catService.listAllLocations();
    }

    @ApiOperation("猫猫签到接口")
    @PostMapping("check")
    public boolean check(@RequestBody CheckRecord checkRecord) {
        return catService.check(checkRecord);
    }

    @ApiOperation("获取所有猫猫打卡记录")
    @GetMapping("list_all_check_records")
    public List<CheckRecordDTO> listAllCheckRecords() {
        return catService.listAllCheckRecords();
    }

    @ApiOperation("猫猫投喂登记接口")
    @PostMapping("feed")
    public boolean feed(@RequestBody FeedRecord feedRecord) {
        return catService.feed(feedRecord);
    }

    @ApiOperation("获取所有投喂记录")
    @GetMapping("list_all_feed_records")
    public List<FeedRecordDTO> listAllFeedRecords() {
        return catService.listAllFeedRecords();
    }
}
