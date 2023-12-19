package com.fyd.schedule.service.impl;

import com.fyd.schedule.dao.SysUserDao;
import com.fyd.schedule.dao.impl.SysUserDaoImpl;
import com.fyd.schedule.pojo.SysUser;
import com.fyd.schedule.service.SysUserService;
import com.fyd.schedule.util.MD5Util;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/19  10:09
 * Description:
 */
public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转换成密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 调用dao层方法
        return sysUserDao.addSysUser(sysUser);
    }

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 找到了返回SysUser对象，找不到返回null
     */
    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
