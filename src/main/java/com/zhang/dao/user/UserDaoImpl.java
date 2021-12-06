package com.zhang.dao.user;

import com.zhang.dao.BaseDao;
import com.zhang.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    //得到要登录的用户信息
    @Override
    public User getLoginUser(Connection connection, String userCode) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        User user = null;


        if(connection != null){
            String sql = "select * from users where userCode=?";
            Object[] params = {userCode};

            try{
                rs = BaseDao.execute(connection, sql, params, rs, pstm);

                if(rs.next()){

                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setBirthday(rs.getDate("birthday"));

                }

                BaseDao.closeResource(null, pstm, rs);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }



        return user;
    }

}
