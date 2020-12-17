package com.xjl.learn.mapper.provider;

import com.xjl.learn.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-11-09-16:57
 */
@Slf4j
public class UserProvider {
    //通过id获取用户信息
    public String getAccountByUserId(String pd){

        Integer userId = Integer.valueOf(pd);
        SQL sql  = new SQL() {
            {
                SELECT("user_id as userId,user_name as userName,user_password as password,user_icon as icon,user_nickname as nickName")
                        .FROM("user")
                        .WHERE("user_id = #{userId}");
            }
        };
        log.info("[UserProvider.getAccountByUserId]通过id获取用户信息\n" + sql.toString());
        return sql.toString();
    }

    //通过账号获取用户信息
    public String getAccountByUserName(User user){

        String userName = user.getUserName();
        SQL sql  = new SQL() {
            {
                SELECT("user_id as userId,user_name as userName,user_password as password")
                        .FROM("user")
                        .WHERE("user_name = #{userName}");
            }
        };
        log.info("[UserProvider.getAccountByUserName]通过账号获取用户信息\n" + sql.toString());
        return sql.toString();
    }
    //插入注册数据
    public String addAccountMassage(User user){

        String userName = user.getUserName();
        String sex = user.getSex();
        String nickName = user.getNickName();
        String password = user.getPassword();
        String birthday = user.getBirthday();
        String email = user.getEmail();
        String introduceText = user.getIntroduceText();
        SQL execSql = new SQL(){
            {
                INSERT_INTO("user")
                        .VALUES("user_name","#{userName}")
                        .VALUES("user_sex","#{sex}")
                        .VALUES("user_nickname","#{nickName}")
                        .VALUES("user_password","#{password}")
                        .VALUES("user_birth","#{birthday}")
                        .VALUES("user_email","#{email}")
                        .VALUES("user_autograph","#{introduceText}")
                        .VALUES("create_time","now()");
            }
        };
        log.info("[loginMapperProvider.addUserAccount]获取当前账号信息\n" + execSql.toString());
        return execSql.toString();
    }
}