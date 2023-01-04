package com.coiggahou.catplatform.dto;

import com.coiggahou.catplatform.entity.Cat;
import com.coiggahou.catplatform.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckRecordDTO {

    String id;
    Location location;
    Date time;
    Cat cat;
}
