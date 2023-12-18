package com.fyd.schedule.dao;

import com.fyd.schedule.pojo.SysSchedule;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:31
 * Description: 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * DAO 一般要定义接口和实现类
 */
public interface SysUserDao {


    /**
     * 新增
     * @param sysSchedule
     * @return
     */
    int insert(SysSchedule sysSchedule);
}
