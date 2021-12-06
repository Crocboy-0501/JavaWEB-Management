package com.zhang.dao.user;

import com.zhang.pojo.User;

import java.sql.Connection;

interface UserDao {
    //得到要登录的用户
    User getLoginUser(Connection connection, String userCode);
}
