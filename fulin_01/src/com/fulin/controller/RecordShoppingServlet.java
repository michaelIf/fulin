package com.fulin.controller;

import com.fulin.dao.FuRecordDao;
import com.fulin.entity.Fu_shopping_record;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class RecordShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordUser,category,goodName;
        Double price,amount,weight,sumPrice;
        String shoppingTime=null;
        String createTime,updateTime;
        Byte status=1;
        FuRecordDao dao=new FuRecordDao();
        Fu_shopping_record fuRecord=null;
        int result=0;
        request.setCharacterEncoding("utf-8");
        PrintWriter out=null;
        HttpSession session=request.getSession();
        recordUser=(String)session.getAttribute("loginUser");
        category=request.getParameter("category");
        // TODO: 2021/9/23 将每个参数的多个值拆开，合并成一条记录，并入库 
        System.out.println("category is "+category);
        goodName=request.getParameter("goodName");
        price=Double.parseDouble(request.getParameter("price"));
        amount=Double.parseDouble(request.getParameter("amount"));
        weight=Double.parseDouble(request.getParameter("weight"));
        sumPrice=Double.parseDouble(request.getParameter("sumPrice"));
        shoppingTime=request.getParameter("shoppingTime");
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        createTime=sdf.format(time);
        updateTime=sdf.format(time);
        fuRecord=new Fu_shopping_record(null,recordUser,category,goodName,price,amount,weight,status,sumPrice,shoppingTime,createTime,updateTime);
        System.out.println("category is "+category);
//        result=dao.addRecord(fuRecord,request);
//        response.setContentType("text/html;charset=utf-8");
//        out=response.getWriter();
        if(result>=1){
            out.print("<font style='color:red;font-size:40'>消费信息增加成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>消费信息增加失败</font>");
        }


    }
}
