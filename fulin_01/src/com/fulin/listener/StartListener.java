package com.fulin.listener;

import com.fulin.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util=new JdbcUtil();
        Map map=new HashMap();
        for (int i=1;i<=20;i++){
            Connection con=util.getCon();
            System.out.println("Http服务器启动市，创建connection"+con);
            map.put(con,true);
        }
        ServletContext app=sce.getServletContext();
        app.setAttribute("key1",map);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext app=sce.getServletContext();
        Map map=(Map) app.getAttribute("key1");
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            Connection con=(Connection) it.next();
            if (con!=null){
                System.out.println("兄弟们，我"+con+"先走一步，20年后还是好汉");
            }
        }

    }
}
