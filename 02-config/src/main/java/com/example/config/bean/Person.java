package com.example.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description: ConfigurationProperties注解表示本类中的所有属性与配置文件进行绑定
 * prefix表示与配置文件中的person下面的所有属性一一映射
 *    PropertySource注解表示从当前路径下person.properties中读取person下的配置文件进行一一映射,使用这个需要将application中的映射注释掉，
 *    不然实验发现，会默认优先映射application.yml中的属性
 * @author: wenchangsheng
 * @date: created in 2019/1/18
 */
//@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    private String name;
    private int age;
    private Map<String, String> map;
    private List<String> list;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
