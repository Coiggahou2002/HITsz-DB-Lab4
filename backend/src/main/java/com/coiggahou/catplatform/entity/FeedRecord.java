package com.coiggahou.catplatform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("feed_records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedRecord {

    @TableId
    String id;

    @TableField
    String userId;

    @TableField
    Date time;

    @TableField
    String locationId;

    @TableField
    String catId;

    @TableField
    String foodId;
}
