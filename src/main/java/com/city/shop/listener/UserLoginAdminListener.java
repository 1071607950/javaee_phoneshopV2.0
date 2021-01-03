package com.city.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class UserLoginAdminListener
 *
 */
@WebListener
public class UserLoginAdminListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public UserLoginAdminListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	 if(event.getName().equals("username")){
    		 ServletContext application=event.getSession().getServletContext();
    		 int usercount=(int)application.getAttribute("usercount")+1;
    		 application.setAttribute("usercount", usercount);
    	 }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
        
    	 if(event.getName().equals("username")){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    		 ServletContext application=event.getSession().getServletContext();
             int usercount=(int)application.getAttribute("usercount")-1;
             application.setAttribute("usercount", usercount);
    	 }
    	 
         
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
       
    }
	
}
