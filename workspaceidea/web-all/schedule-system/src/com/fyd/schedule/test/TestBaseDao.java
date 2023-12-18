package com.fyd.schedule.test;

import com.fyd.schedule.dao.BaseDao;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:24
 * Description:
 */
public class TestBaseDao {
    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }
    @Test
    public void testBaseQueryObject() {
        // 查询用户数据 查询结果是单行单列的
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class,sql);
        System.out.println(count);
    }
}
