package com.zyy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyy.controller.utils.UnifiedDataFormat;
import com.zyy.dao.IBookDao;
import com.zyy.domain.Book;
import com.zyy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<IBookDao, Book> implements IBookService {
    @Autowired
    private IBookDao dao;


    /**
     * 不带筛选条件的分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {

        IPage<Book> page=new Page<Book>(currentPage,pageSize);

        return dao.selectPage(page,null);
    }

    /**
     * 带条件的分页查询
     * @param currentPage
     * @param pageSize
     * @param book
     * @return
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        IPage<Book> page=new Page<Book>(currentPage,pageSize);

        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        lqw.like(book!=null,Book::getType,book.getType());
        lqw.like(book!=null,Book::getName,book.getName());
        lqw.like(book!=null,Book::getDescription,book.getDescription());
        dao.selectPage(page,lqw);


        return page;
    }
}
