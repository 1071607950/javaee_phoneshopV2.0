package com.city.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebClickCountListener
 *
 */
@WebListener
public class WebClickCountListener implements ServletRequestListener {

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
       
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent  event)  { 
        ServletContext application=event.getServletContext();
        int clickcount=(int)application.getAttribute("clickcount")+1;
        application.setAttribute("clickcount", clickcount);
        
        
    	
    }
	
}
