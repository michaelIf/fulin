package com.fulin.entity;

import java.util.Date;

public class Fu_shopping_record {
    private Integer recordId;//记录编号
    private String recordUser;//记录者
    private String category;//记录品类
    private Double price;//记录单价
    private Double amount;//记录数量
    private Double weight;//记录重量
    private Byte status;//记录状态 1成功，2全额退款，3部分退款
    private Double sumPrice;//记录总价
    private Date shoppingTime;//消费时间
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public void setRecordUser(String recordUser) {
        this.recordUser = recordUser;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public void setShoppingTime(Date shoppingTime) {
        this.shoppingTime = shoppingTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public String getRecordUser() {
        return recordUser;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getWeight() {
        return weight;
    }

    public Byte getStatus() {
        return status;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public Date getShoppingTime() {
        return shoppingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Fu_shopping_record() {
    }

    public Fu_shopping_record(Integer recordId, String recordUser, String category, Double price, Double amount, Double weight, Byte status, Double sumPrice, Date shoppingTime, Date createTime, Date updateTime) {
        this.recordId = recordId;
        this.recordUser = recordUser;
        this.category = category;
        this.price = price;
        this.amount = amount;
        this.weight = weight;
        this.status = status;
        this.sumPrice = sumPrice;
        this.shoppingTime = shoppingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
