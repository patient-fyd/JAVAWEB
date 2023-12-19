package com.fyd.schedule.service;

import com.fyd.schedule.pojo.SysUser;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/19  10:08
 * Description: 该接口定义了以sys_user表格为核心的业务处理功能
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser 要注册的用户名和明文密码以SysUser对象的形式接收
     * @return 注册成功返回1 注册失败返回0
     */
    int regist(SysUser sysUser);
}
