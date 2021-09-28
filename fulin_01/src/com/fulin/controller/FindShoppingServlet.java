package com.fulin.controller;

import com.fulin.dao.FuRecordDao;
import com.fulin.entity.Fu_shopping_record;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindShoppingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FuRecordDao dao=new FuRecordDao();
        PrintWriter out;
        List<Fu_shopping_record> recordList=dao.findDefault10();
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>记录者</td>");
        out.print("<td>品类</td>");
        out.print("<td>名称</td>");
        out.print("<td>价格</td>");
        out.print("<td>数量</td>");
        out.print("<td>重量</td>");
        out.print("<td>总价</td>");
        out.print("<td>购物时间</td>");
        out.print("<td>记录时间</td>");
        out.print("<td>消费者</td>");
        out.print("</tr>");
        for (Fu_shopping_record record:recordList){
            out.print("<tr>");
            out.print("<td>"+record.getRecordUser()+"</td>");
            out.print("<td>"+record.getCategory()+"</td>");
            out.print("<td>"+record.getGoodName()+"</td>");
            out.print("<td>"+record.getPrice()+"</td>");
            out.print("<td>"+record.getAmount()+"</td>");
            out.print("<td>"+record.getWeight()+"</td>");
            out.print("<td>"+record.getSumPrice()+"</td>");
            out.print("<td>"+record.getShoppingTime()+"</td>");
            out.print("<td>"+record.getCreateTime()+"</td>");
            out.print("<td>"+record.getConsumer()+"</td>");
            out.print("<td><a href='/myWeb/user/delete?userId="+record.getRecordId()+"'>删除记录</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");

    }


}
