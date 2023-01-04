package com.coiggahou.catplatform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("cats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    @TableId
    String id;

    @TableField
    String name;

    @TableField
    String typeId;

    @TableField
    String colorId;

    @TableField
    String characterId;

    @TableField
    String aroundLocationId;

}
