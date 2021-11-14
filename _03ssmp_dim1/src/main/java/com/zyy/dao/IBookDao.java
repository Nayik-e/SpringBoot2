package com.zyy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zyy.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBookDao extends BaseMapper<Book> {
}
