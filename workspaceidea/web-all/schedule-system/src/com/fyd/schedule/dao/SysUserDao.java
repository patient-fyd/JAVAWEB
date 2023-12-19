package com.fyd.schedule.dao;

import com.fyd.schedule.pojo.SysSchedule;
import com.fyd.schedule.pojo.SysUser;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:31
 * Description: 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * DAO 一般要定义接口和实现类
 */
public interface SysUserDao {


    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username和user_pwd字段，以sys User实体类对象的形式接收
     * @return 返回受影响的行数
     */
    int addSysUser(SysUser sysUser);
}
