package com.zyy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById(){
        iBookService.getById(1);
    }


    @Test
    void testGetAll(){
        iBookService.list();
    }

    @Test
    void testGetPage(){
        iBookService.page(new Page<Book>(1,5));
    }
}
