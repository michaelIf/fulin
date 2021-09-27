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
import java.util.ArrayList;
import java.util.List;

public class RecordShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordUser,category,goodName,consumer;
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
//        category=request.getParameter("category");
        // TODO: 2021/9/23 将每个参数的多个值拆开，合并成一条记录，并入库 
//        System.out.println("category is "+category);
//        goodName=request.getParameter("goodName");
        String [] goodNames=request.getParameterValues("goodName");
        String [] categorys=request.getParameterValues("category");
        String [] prices=request.getParameterValues("price");
        String [] amounts=request.getParameterValues("amount");
        String [] weights=request.getParameterValues("weight");
        String [] sumPrices=request.getParameterValues("sumPrice");
        String [] shoppingTimes=request.getParameterValues("shoppingTime");
        String [] consumers=request.getParameterValues("consumer");
        for (int i=0;i<goodNames.length;i++){
            goodName=goodNames[i];
            if (goodName.equals("")||goodName.isEmpty()){
                break;
            }
            category=categorys[i];
            price=Double.parseDouble(prices[i]);
            amount=Double.parseDouble(amounts[i]);
            weight=Double.parseDouble(weights[i]);
            sumPrice=Double.parseDouble(sumPrices[i]);
            shoppingTime=shoppingTimes[i];
            Date time = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createTime=sdf.format(time);
            updateTime=sdf.format(time);
            consumer=consumers[i];
            fuRecord=new Fu_shopping_record(null,recordUser,category,goodName,price,amount,weight,status,sumPrice,shoppingTime,createTime,updateTime,consumer);
            int temp=dao.addRecord(fuRecord,request);
            result +=temp;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        price=Double.parseDouble(request.getParameter("price"));
//        amount=Double.parseDouble(request.getParameter("amount"));
//        weight=Double.parseDouble(request.getParameter("weight"));
//        sumPrice=Double.parseDouble(request.getParameter("sumPrice"));
//        shoppingTime=request.getParameter("shoppingTime");
//        Date time = new Date(System.currentTimeMillis());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        createTime=sdf.format(time);
//        updateTime=sdf.format(time);
//        fuRecord=new Fu_shopping_record(null,recordUser,category,goodName,price,amount,weight,status,sumPrice,shoppingTime,createTime,updateTime);
//        System.out.println("category is "+category);
//        result=dao.addRecord(fuRecord,request);
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==goodNames.length){
            out.print("<font style='color:red;font-size:40'>消费信息增加成功"+result+"条</font>");
        }else if (result==0){
            out.print("<font style='color:red;font-size:40'>消费信息增加失败</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>消费信息增加成功"+result+"条，失败"+(goodNames.length-result)+"条</font>");
        }


    }
}
