package com.zyy._02mybatis;

import com.zyy.dao.UserDao;
import com.zyy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = userDao.getById(1);
        System.out.println(user);
    }

}
