package com.coiggahou.catplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coiggahou.catplatform.entity.Food;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
}
