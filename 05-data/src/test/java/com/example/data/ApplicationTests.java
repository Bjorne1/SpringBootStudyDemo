package com.example.data;

import com.example.data.druid.bean.Person;
import com.example.data.druid.service.PersonService;
import com.example.data.jpa.dao.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    public IUserRepository userRepository;
    @Autowired
    private PersonService personService;

    @Test
    public void contextLoads() {
        Person person = personService.getById("1");
        System.out.println(person);
    }

    @Test
    public void jpaTest() {
        //User user = userRepository.getUserByAge(3);
//        User user2 = new User();
//        user2.setId(2);
//        user2.setAge(6);
//        user2.setUserName("赵子龙");
//        userRepository.save(user2);
//        System.out.println(user2);
        System.out.println(userRepository.findUserByUserNameAndAge("赵子龙", 6));
    }

}

