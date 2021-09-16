package com.fulin.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
    final String URL="jdbc:mysql://localhost:3306/fulin";
    final String USERNAME="root";
    final String PASSWORD="root";
    PreparedStatement ps= null;
    Connection con = null;



    //---------------------------通过全局作用域对象得到Connection------------start
    // 将jar包中driver实现类加载到JVM中
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装连接通道创建细节
    public Connection getCon(HttpServletRequest request){
        //通过请求对象，得到全局作用域对象
        ServletContext app=request.getServletContext();
        //从全局作用域对象得到map
        Map map=(Map) app.getAttribute("key1");
        //从map得到一个处于空闲状态的Connection
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            con=(Connection) it.next();
            //得到连接的状态
            boolean flag=(boolean)map.get(con);
            //判断连接是否被占用
            if (flag==true){
                //占用该连接，并将状态置为false
                map.put(con,false);
                break;
            }
        }
        return con;
    }

    //封装交通工具创建细节
    public PreparedStatement createStatement(String sql,HttpServletRequest request){
        try {
            ps=getCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //ps与con销毁细节 insert，update，delete
    public void close(HttpServletRequest request){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //找到该连接
        ServletContext app=request.getServletContext();
        Map map=(Map) app.getAttribute("key1");
        //将状态置为true
        map.put(con,true);
    }
    //select ps，con，rs
    public void close(ResultSet rs,HttpServletRequest request){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(request);
    }


    //封装连接通道创建细节
    public Connection getCon(){
        try {
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //封装交通工具创建细节
    public PreparedStatement createStatement(String sql){
        try {
            ps=getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //ps与con销毁细节 insert，update，delete
    public void close(){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //select ps，con，rs
    public void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }

}
