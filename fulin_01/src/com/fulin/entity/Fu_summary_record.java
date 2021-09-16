package com.fulin.entity;

import java.util.Date;

public class Fu_summary_record {
    private Integer summaryId;//汇总编号
    private Byte status;//汇总状态，1成功，2汇总中，3失败
    private Byte summaryWay;//汇总方式，1按时间，2按品类，3按时间+品类
    private Date beginDate;//汇总开始时间
    private Date endDate;//汇总结束时间
}
