package com.fyd.schedule.dao.impl;

import com.fyd.schedule.dao.BaseDao;
import com.fyd.schedule.dao.SysUserDao;
import com.fyd.schedule.pojo.SysSchedule;
import com.fyd.schedule.pojo.SysUser;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:39
 * Description:
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(null,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }
}
