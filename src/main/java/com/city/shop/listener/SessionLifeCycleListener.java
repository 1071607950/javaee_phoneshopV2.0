package com.city.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionLifeCycleListener
 *
 */
@WebListener
public class SessionLifeCycleListener implements HttpSessionListener {

    

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
        System.out.println("会话对象创建了");
        //ServletContext application=event.getSession().getServletContext();
        // int usercount=(int)application.getAttribute("usercount")+1;
        // application.setAttribute("usercount", usercount);
        
        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("会话对象销毁了");
    }
	
}
