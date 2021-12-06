package com.zhang.service.user;

import com.zhang.pojo.User;

public interface UserService {
    //用户登陆
    public User Login(String usercode, String password);
}
