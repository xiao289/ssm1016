package com.service;

import com.bean.UserTb;

public interface UserTbService {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
    UserTb login(UserTb userTb);
}
