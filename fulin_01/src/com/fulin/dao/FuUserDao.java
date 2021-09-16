package com.fulin.dao;

import com.fulin.entity.Fu_users;
import com.fulin.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FuUserDao {
    private JdbcUtil util=new JdbcUtil();

    public int addUser(Fu_users user){

        String sql="insert into users(userName,password,sex,email,phone)"+
                "values(?,?,?,?,?)";
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPhone());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
}
