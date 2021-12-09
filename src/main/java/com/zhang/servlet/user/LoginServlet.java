package com.zhang.servlet.user;

import com.zhang.pojo.User;
import com.zhang.service.user.UserService;
import com.zhang.service.user.UserServiceImpl;
import com.zhang.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----****----LoginServlet--starting----****----");
        //获取用户和密码
        String userCode = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        //和数据库中的密码比对，调用业务层

        UserService userService = new UserServiceImpl();
        User user = userService.Login(userCode, password);

        if(user!=null){//存在此人，可以登陆
            //将用户信息放入session
            req.getSession().setAttribute(Constants.USER_SESSION, user);

            //跳转欢迎界面
            resp.sendRedirect("welcome.html");
            System.out.println(user.getBirthday());

        }

    }
}



