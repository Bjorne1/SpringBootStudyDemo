package com.example.data.druid.dao;

import com.example.data.druid.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: Mapper指定这是一个操作数据库的Mapper
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 10:33
 */
@Mapper
public interface IPersonDao {

    @Select("SELECT id,user_name,age FROM User WHERE id = #{id}")
    Person getById(String id);
}
