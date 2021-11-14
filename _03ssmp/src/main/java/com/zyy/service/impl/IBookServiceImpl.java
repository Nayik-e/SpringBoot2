package com.zyy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyy.dao.BookDao;
import com.zyy.domain.Book;
import com.zyy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService  {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int size) {
        IPage<Book> page=new Page<Book>(currentPage,size);
        return bookDao.selectPage(page,null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int size, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();

        lqw.like(book.getName()!=null,Book::getName,book.getName());
        lqw.like(book.getType()!=null,Book::getType,book.getType());
        lqw.like(book.getDescription()!=null,Book::getDescription,book.getDescription());

        IPage<Book> page=new Page<Book>(currentPage,size);
        return bookDao.selectPage(page,lqw);
    }
}
