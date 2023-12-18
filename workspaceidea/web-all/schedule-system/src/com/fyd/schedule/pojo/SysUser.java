package com.fyd.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/18  20:02
 * Description: user实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    /*
    * 类名和表格名称对应
    * 实体类的属性和表格的列名应该对应
    * 每个属性都必须是私有的
    * 每个属性都应该具备getter和setter
    * 必须具备无参构造器
    * 应该实现序列化接口（缓存 分布式项目数据传递可能会将对象序列化）
    * 应该重写类的hashcode和equals方法
    * */
    private Integer uid;
    private String username;
    private String userPwd;
}
