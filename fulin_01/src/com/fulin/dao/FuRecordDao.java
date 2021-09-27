package com.fulin.dao;

import com.fulin.entity.Fu_shopping_record;
import com.fulin.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuRecordDao {
    private JdbcUtil util=new JdbcUtil();
    //插入记录
    public int addRecord(Fu_shopping_record fuRecord, HttpServletRequest request){
        String sql="insert into fu_shopping_record(recordUser,category,goodName,price,amount,weight,`status`,sumPrice,shoppingTime,createTime,updateTime,consumer)"+
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=util.createStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,fuRecord.getRecordUser());
            ps.setString(2,fuRecord.getCategory());
            ps.setString(3,fuRecord.getGoodName());
            ps.setDouble(4,fuRecord.getPrice());
            ps.setDouble(5,fuRecord.getAmount());
            ps.setDouble(6,fuRecord.getWeight());
            ps.setInt(7,fuRecord.getStatus());
            ps.setDouble(8,fuRecord.getSumPrice());
            ps.setString(9,fuRecord.getShoppingTime());
            ps.setString(10,fuRecord.getCreateTime());
            ps.setString(11,fuRecord.getUpdateTime());
            ps.setString(12,fuRecord.getConsumer());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    //查找最近的10条
    public List findDefault10(){
        String sql="select * from fu_shopping_record order by recordId desc limit 10";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        List<Fu_shopping_record> recordList=new ArrayList<>();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer recordId=rs.getInt("recordId");
                String recordUser=rs.getString("recordUser");
                String category=rs.getString("category");
                String goodName=rs.getString("goodName");
                Double price=rs.getDouble("price");
                Double amount=rs.getDouble("amount");
                Double weight=rs.getDouble("weight");
                Byte status=rs.getByte("status");
                Double sumPrice=rs.getDouble("sumPrice");
                String shoppingTime=rs.getString("shoppingTime");
                String createTime=rs.getString("createTime");
                String updateTime=rs.getString("updateTime");
                String consumer=rs.getString("consumer");
                Fu_shopping_record shoppingRecord=new Fu_shopping_record(recordId,recordUser,category,goodName,price,amount,weight,status,sumPrice,shoppingTime,createTime,updateTime,consumer);
                recordList.add(shoppingRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return recordList;
    }
    //按品类查询
    public List findCategory(String category){
        String sql="select * from fu_shopping_record where category=?"+"values()";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        List<Fu_shopping_record> recordList=new ArrayList<>();
        return recordList;
    }
}
