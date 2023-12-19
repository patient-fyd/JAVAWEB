package com.fyd.schedule.dao.impl;

import com.fyd.schedule.dao.BaseDao;
import com.fyd.schedule.dao.SysUserDao;
import com.fyd.schedule.pojo.SysSchedule;
import com.fyd.schedule.pojo.SysUser;

import java.util.List;

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

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username=?";
        List<SysUser> sysUserList = baseQuery(SysUser.class,sql,username);
        return sysUserList!=null && sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }
}
