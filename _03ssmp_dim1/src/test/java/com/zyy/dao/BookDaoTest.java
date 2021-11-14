package com.zyy.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private IBookDao bookDao;
    @Test
    void testPage(){
        IPage page=new Page(1,5);
        bookDao.selectPage(page,null);
    }
}
