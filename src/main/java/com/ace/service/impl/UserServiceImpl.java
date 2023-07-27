package com.ace.service.impl;

import com.ace.dao.UserDao;
import com.ace.service.UserService;
import org.springframework.beans.factory.InitializingBean;

public class UserServiceImpl implements UserService, InitializingBean {
    private UserDao userDao;

    public UserServiceImpl(){
        System.out.println("UserServiceImpl构造函数");
    }

    public void hello(String username) {
        System.out.println("hello " + username);
    }

    public void userDaoSayHello(String s) {
        this.userDao.hello(s);
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("依赖注入 userDao");
        this.userDao = userDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("依赖注入完毕");
    }

    public void init(){
        System.out.println("开始init");
    }
}
