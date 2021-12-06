package com.zhang.dao.user;

import com.zhang.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode);
}
