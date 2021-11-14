package com.zyy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyy.domain.Book;

public interface IBookService extends IService<Book> {

    //分页
    IPage<Book> getPage(int currentPage,int size);
    IPage<Book> getPage(int currentPage,int size,Book book);
}
