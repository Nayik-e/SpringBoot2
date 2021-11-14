package com.zyy.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;


    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave(){
        Book book=new Book();
        book.setName("计算机组成原理");
        book.setType("计算机");
        book.setDescription("法撒旦话费卡设计的佛尔偶分");

        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book=new Book();
        book.setId(1);
        book.setName("c++++");
        book.setType("计算机");
        book.setDescription("fdsafasgas");

        bookDao.updateById(book);
    }

    @Test
    void testPage(){
        IPage page=new Page(1,5);
        bookDao.selectPage(page,null);
    }


    @Test
    void testGetByCondition(){
        String name="d";
        QueryWrapper<Book> qw = new QueryWrapper<Book>();
        qw.like(name!=null,"name",name);
        bookDao.selectList(qw);
    }

    @Test
    void testGetByCondition2(){

        String name="计算机";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }

}
