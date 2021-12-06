package com.zhang.service.user;


import com.zhang.dao.BaseDao;
import com.zhang.dao.user.UserDao;
import com.zhang.dao.user.UserDaoImpl;
import com.zhang.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    //业务层需要调用dao，需要导入dao
    private UserDao userdao;
    public UserServiceImpl(){
        userdao = new UserDaoImpl();
    }

    @Override
    public User Login(String usercode, String password) {

        Connection connection = null;
        User user = null;

        try{
            connection = BaseDao.getConnection();
            //通过业务层调用具体查询数据库功能
            user = userdao.getLoginUser(connection, usercode);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.Login("xiaoxiao", "123456");
        System.out.println(user.getBirthday());
    }

}
