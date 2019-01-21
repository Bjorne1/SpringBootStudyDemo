package com.example.data;

import com.example.data.druid.bean.Person;
import com.example.data.druid.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    public void contextLoads() {
        Person person = personService.getById("1");
        System.out.println(person);
    }

}

