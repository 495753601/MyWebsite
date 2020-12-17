package com.xjl.learn.service;

import com.xjl.learn.entity.User;
import com.xjl.learn.mapper.UserMapper;
import com.xjl.learn.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-11-09-17:14
 */
@Service
public class UserService {

    @Autowired(required=false)
    private UserMapper userMapper;

    //通过id获取用户信息
    public User getAccountByUserId(String userId){
        return userMapper.getAccountByUserId(userId);
    }

    //通过账号获取用户信息
    public User getAccountByUserName(User user){
        return userMapper.getAccountByUserName(user);
    }
//    public Map<String,Object> getAccountByUserName(Map<String,Object> pd){
//        return userMapper.getAccountByUserName(pd);
//    }
    //插入注册信息
    public void addAccountMassage(User user){
        user.setPassword(Md5Util.strMd5(user.getPassword()));
        userMapper.addAccountMassage(user);
    }
}