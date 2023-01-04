package com.coiggahou.catplatform.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.coiggahou.catplatform.entity.CatType;
import com.coiggahou.catplatform.entity.Character;
import com.coiggahou.catplatform.entity.Color;
import com.coiggahou.catplatform.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatDTO {
    String id;
    String name;
    CatType type;
    Color color;
    Character character;
    Location aroundLocation;
}
