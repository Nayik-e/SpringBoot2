package com.zyy.dao;

import com.zyy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {
    @Select("select * from  t_user where id=#{id}")
    public User getById(Integer id);

}
