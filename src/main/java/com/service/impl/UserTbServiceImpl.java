package com.service.impl;

import com.bean.UserTb;
import com.dao.UserTbMapper;
import com.service.UserTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTbServiceImpl implements UserTbService {

    @Autowired
    private UserTbMapper userTbMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(UserTb record) {
        return 0;
    }

    @Override
    public int insertSelective(UserTb record) {
        return 0;
    }

    @Override
    public UserTb selectByPrimaryKey(Integer userId) {
        return userTbMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(UserTb record) {
        return userTbMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserTb record) {
        return 0;
    }

    @Override
    public UserTb login(UserTb userTb) {
        UserTb userTb1=  userTbMapper.login(userTb.getUserName());
        if(userTb1!=null&&userTb1.getUserPs().equals(userTb.getUserPs())){
            //修改登录次数
              userTb1.setLogincount(userTb1.getLogincount()+1);
              userTbMapper.updateByPrimaryKeySelective(userTb1);
            return userTb1;
        }
        return null;
    }
}
