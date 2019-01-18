package com.example.config;

import com.example.config.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Person person;

    @Test
    public void contextLoads() {
        //Person{name='wcs', age=24, map={k1=v1, k2=v2}, list=[list1, list2], dog=Dog{name='Huang', age=3}}
        System.out.println(person);
    }

}

