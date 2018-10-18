package com.dao;

import com.bean.UserTb;

import java.util.List;

public interface UserTbMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
    //登录
    UserTb login(String name);
}