package com.zyy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyy.domain.Book;

import java.util.List;

public interface BookService {
    Boolean update(Book book);
    Boolean delete(Integer id);
    Boolean save(Book book);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(Page page);
}
