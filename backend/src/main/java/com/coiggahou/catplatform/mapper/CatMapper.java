package com.coiggahou.catplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coiggahou.catplatform.entity.Cat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatMapper extends BaseMapper<Cat> {
}
