package com.xjl.learn.controller;

import com.xjl.learn.annotation.UserLoginToken;
import com.xjl.learn.entity.R;
import com.xjl.learn.entity.User;
import com.xjl.learn.exception.LoginCheckException;
import com.xjl.learn.exception.RRException;
import com.xjl.learn.service.UserService;
import com.xjl.learn.util.Md5Util;
import com.xjl.learn.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * @Description:
 * @author: xjl
 * @date: 2020-11-09-16:33
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //登陆
    @PostMapping("/user/login")
    public R login(@RequestBody User user){

        log.info("参数："+ user.toString());
        User userMassage = userService.getAccountByUserName(user);
        user.setPassword(Md5Util.strMd5(user.getPassword()));
        if(userMassage == null){
            throw new LoginCheckException("该账号未注册");
        }else{
            if (user.getPassword().equals(userMassage.getPassword())){
                String token = TokenUtil.getToken(userMassage);
                return R.ok().put("token",token);
            }else{
                throw new LoginCheckException("密码错误");
            }
        }
    }
    //注册
    @PostMapping("/user/regiest")
    public R regiest(@RequestBody User user){

        log.info("参数："+ user.toString());
        userService.addAccountMassage(user);
        return R.ok();
    }
    @UserLoginToken
    @GetMapping("/user/testget")
    public String testGet(){
        return "你已通过验证";
    }

}