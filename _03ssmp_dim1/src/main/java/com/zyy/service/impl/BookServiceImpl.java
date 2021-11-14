package com.zyy.service.impl;

import com.zyy.dao.BookDao;
import com.zyy.domain.Book;
import com.zyy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }
}
