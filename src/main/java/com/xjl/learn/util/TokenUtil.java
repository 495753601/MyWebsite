package com.xjl.learn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xjl.learn.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-11-09-16:12
 */
public class TokenUtil {
    //生成token
    public static String getToken(User user) {

        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);

        String token="";
        token= JWT.create().withAudience(user.getUserId().toString())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
    //获取token中的id
    public static String getIdByToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        String userId = JWT.decode(token).getAudience().get(0);;
        return userId;
    }
}