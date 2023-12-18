package com.fyd.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:27
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
