package com.xjl.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:用户
 * @author: xjl
 * @date: 2020-11-09-16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer userId;
    String userName;
    String password;
    String userAge;
    String nickName;
}