package com.coiggahou.catplatform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("check_records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckRecord {

    @TableId
    String id;

    @TableField
    String locationId;

    @TableField
    Date time;

    @TableField
    String catId;
}
