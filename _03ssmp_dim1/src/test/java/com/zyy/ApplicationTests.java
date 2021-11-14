package com.zyy;

import com.zyy.domain.Book;
import com.zyy.service.BookService;
import com.zyy.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookService bookService;
    @Autowired
    private IBookService iBookService;

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Test
    void testGetById(){
        Book book = bookService.getById(1);
        System.out.println(book);
    }

    @Test
    void testMP(){
        Book book = iBookService.getById(1);
        System.out.println(book);
    }

    @Test
    void testInc(){
        Book book=new Book();
        book.setName("test2_dim");
        iBookService.save(book);

    }


}
