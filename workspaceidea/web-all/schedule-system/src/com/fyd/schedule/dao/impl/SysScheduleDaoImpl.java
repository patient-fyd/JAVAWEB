package com.fyd.schedule.dao.impl;

import com.fyd.schedule.dao.BaseDao;
import com.fyd.schedule.dao.SysScheduleDao;
import com.fyd.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:39
 * Description:
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> sysSchedules = baseQuery(SysSchedule.class, sql);
        return sysSchedules;
    }
}
