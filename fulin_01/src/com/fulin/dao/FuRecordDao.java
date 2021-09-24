package com.fulin.dao;

import com.fulin.entity.Fu_shopping_record;
import com.fulin.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuRecordDao {
    private JdbcUtil util=new JdbcUtil();
    //插入记录
    public int addRecord(Fu_shopping_record fuRecord, HttpServletRequest request){
        String sql="insert into fu_shopping_record(recordUser,category,goodName,price,amount,weight,`status`,sumPrice,shoppingTime,createTime,updateTime)"+
                "values(?,?,?,?,?,?,?,?,?,?,?)";
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
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
