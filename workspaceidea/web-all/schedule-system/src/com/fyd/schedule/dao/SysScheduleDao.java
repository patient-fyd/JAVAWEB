package com.fyd.schedule.dao;

import com.fyd.schedule.pojo.SysSchedule;

import java.util.List;

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

    /**
     * 查询所有用户的所有日程
     * @return 将所有日程放入应该List集合中返回
     */
    List<SysSchedule> findAll();
}
