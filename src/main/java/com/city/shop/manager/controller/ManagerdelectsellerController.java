package com.city.shop.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.service.IManagerService;

/**
 * 
 * @author
 * @category 删除卖家后处理
 */
@WebServlet("/pages/admin/delectseller.do")
public class ManagerdelectsellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerdelectsellerController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role =(String)request.getSession().getAttribute("role");
		String sellerId=request.getParameter("sellerId");
		if(role==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}else if(role.equals("9")){
			IManagerService managerService= ServiceFactory.createManagerservice();
			try {
				if(managerService.delectSeller(sellerId)){
				
					request.getRequestDispatcher("tomanagerseller.do").forward(request, response);
				}
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("msg", "没有权限访问");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
