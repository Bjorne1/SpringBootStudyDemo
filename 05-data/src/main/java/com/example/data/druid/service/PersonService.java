package com.example.data.druid.service;

import com.example.data.druid.bean.Person;
import com.example.data.druid.dao.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/21 10:37
 */
@Service
public class PersonService {
    @Autowired
    private IPersonDao personDao;

    public Person getById(String id) {
        return personDao.getById(id);
    }
}
