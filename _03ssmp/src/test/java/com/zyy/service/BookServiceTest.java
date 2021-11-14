package com.zyy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Test
    void testGetAll(){
        List<Book> bookList=bookService.getAll();
    }


    @Test
    void testDelete(){
        System.out.println("删除成功吗？==》"+bookService.delete(7));
    }

    @Test
    void testSave(){
        Book book=new Book();
        book.setName("test2");
        bookService.save(book);
        testGetAll();
    }

    @Test
    void testPage(){
        bookService.getPage(new Page(1,3));
    }
}
