package com.example.data.jpa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 11:11
 */
@Entity
@Table(name = "User")//指定表面，不指定则默认为User
public class User {

    @Id
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
