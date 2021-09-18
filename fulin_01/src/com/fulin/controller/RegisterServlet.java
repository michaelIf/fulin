package com.fulin.controller;

import com.fulin.dao.FuUserDao;
import com.fulin.entity.Fu_users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,email,phone,sex,password;
        FuUserDao dao=new FuUserDao();
        Fu_users user=null;
        int result=0;
        PrintWriter out=null;
        //解决性别传值为男时写入数据库为乱码问题
        request.setCharacterEncoding("utf-8");
        userName=request.getParameter("userName");
        email=request.getParameter("email");
        phone=request.getParameter("phone");
        sex=request.getParameter("sex");
        password=request.getParameter("password");
        user=new Fu_users(null,userName,password,sex,email,phone);
        result=dao.addUser(user,request);
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if (result==1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }

    }
}
