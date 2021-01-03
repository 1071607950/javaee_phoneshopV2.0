package com.city.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndStopListener
 *
 */
@WebListener
public class ServerStartAndStopListener implements ServletContextListener {

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	 System.out.println("服务器停止了");
    }

	/**
     * 监听服务器启动方法
     */
    public void contextInitialized(ServletContextEvent event)  { 
         System.out.println("服务器启动了");
         ServletContext application=event.getServletContext();
         //设置登录用户人数
         application.setAttribute("usercount",0);
        //设置网站点击次数
         application.setAttribute("clickcount",0);
         //设置登录用户列表容器
         List<String> userlist=new ArrayList<String>();
         application.setAttribute("userlist",userlist);
         
         
         
         
         
         
         
         
         
    }
	
}
