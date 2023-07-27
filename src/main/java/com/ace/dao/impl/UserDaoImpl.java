package com.ace.dao.impl;

import com.ace.dao.UserDao;
import com.ace.service.UserService;

public class UserDaoImpl implements UserDao {
    public UserService userService;

    public UserDaoImpl(){
        System.out.println("UserDaoImpl构造函数");
    }

    public void hello(String msg) {
        System.out.println("hello：" + msg);
    }

    public void setUserService(UserService userService){
        System.out.println("依赖注入 userService");
        this.userService = userService;
    }
}
