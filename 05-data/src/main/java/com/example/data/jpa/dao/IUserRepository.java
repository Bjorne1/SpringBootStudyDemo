package com.example.data.jpa.dao;

import com.example.data.jpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 11:13
 */
public interface IUserRepository extends JpaRepository<User, Integer> {

    /**
     * 表面设置了User，但是console显示未找到my_test.user,为啥还是小写。。
     *
     * @param age 年龄
     */
    User getUserByAge(Integer age);
}
