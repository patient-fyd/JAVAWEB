package com.fyd.schedule.dao;

import com.fyd.schedule.pojo.SysSchedule;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:33
 * Description:
 */
public interface SysScheduleDao {

    /**
     * 用于向表中插入一条日程记录
     * @param sysSchedule 日程数据以SysSchedule实体类对象形式入参
     * @return 返回影响数据库记录的行数，行数为零说明增加失败，大于零说明增加成功
     */
    int addSchedule(SysSchedule sysSchedule);
}
