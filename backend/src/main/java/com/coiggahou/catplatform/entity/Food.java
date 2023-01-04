package com.coiggahou.catplatform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @TableId
    String id;

    @TableField
    String name;
}
