package com.xjl.learn.mapper;

import com.xjl.learn.entity.User;
import com.xjl.learn.mapper.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;

/**
 * @Description:用户
 * @author: xjl
 * @date: 2020-11-09-16:53
 */
@Mapper
public interface UserMapper {
    //通过id获取用户信息
    @SelectProvider(type = UserProvider.class, method = "getAccountByUserId")
    public User getAccountByUserId(String userId);
    //通过账号获取用户信息
    @SelectProvider(type = UserProvider.class, method = "getAccountByUserName")
    public User getAccountByUserName(User user);
    //public Map<String,Object> getAccountByUserName(Map<String,Object> pd);
    //插入用户注册信息
    @InsertProvider(type = UserProvider.class, method = "addAccountMassage")
    public void addAccountMassage(User user);
}