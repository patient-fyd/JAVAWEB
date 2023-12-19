package com.fyd.schedule.test;

import com.fyd.schedule.dao.SysScheduleDao;
import com.fyd.schedule.dao.impl.SysScheduleDaoImpl;
import com.fyd.schedule.pojo.SysSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/19  9:16
 * Description:
 */
public class TestSysScheduleDao {
    private static SysScheduleDao sysScheduleDao;
    @BeforeClass
    public static void initSysScheduleDao(){
        sysScheduleDao = new SysScheduleDaoImpl();
    }
    @Test
    public void testAddSchedule(){
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null,2,"学习2",0));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> sysSchedules = sysScheduleDao.findAll();
        sysSchedules.forEach(System.out::println);
    }
}
