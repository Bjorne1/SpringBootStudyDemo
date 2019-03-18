package com.example.data;

import com.example.data.druid.bean.Person;
import com.example.data.druid.service.PersonService;
import com.example.data.jpa.bean.User;
import com.example.data.jpa.dao.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
//        System.out.println(userRepository.findUserByUserNameAndAge("赵子龙", 6));
        //批量添加
//        User user = new User();
//        user.setId(3);
//        user.setUserName("wcs2");
//        user.setAge(32);
//        User user2 = new User();
//        user2.setId(4);
//        user2.setUserName("wcs3");
//        user2.setAge(43);
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//        userList.add(user2);
//        userRepository.saveAll(userList);
        //分页
        Pageable pageable = PageRequest.of(1, 2);
        Page<User> userPage = userRepository.findAll(pageable);
        System.out.println(userPage.getTotalElements());
        System.out.println(userPage.getTotalPages());
        List<User> userList = userPage.getContent();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}

