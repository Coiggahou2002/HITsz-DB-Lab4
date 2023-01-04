package com.coiggahou.catplatform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("cat_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatType {
    @TableId
    String id;

    @TableField
    String name;
}
