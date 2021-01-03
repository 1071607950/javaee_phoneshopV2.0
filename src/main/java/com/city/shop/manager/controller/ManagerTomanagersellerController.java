package com.city.shop.manager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Seller;
import com.city.shop.service.IManagerService;

/**
 * 
 * @category 全部卖家列表前分发
 *
 */
 
@WebServlet("/pages/admin/tomanagerseller.do")
public class ManagerTomanagersellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerTomanagersellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role =(String)request.getSession().getAttribute("role");
		System.out.println(role);
		if(role==null) {
			request.setAttribute("msg", "请先登录");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}else if(role.equals("9")){
			IManagerService managerService=ServiceFactory.createManagerservice();
			List<Seller> sellerlist=new ArrayList<Seller>();
			try {
				sellerlist = managerService.lookAllSeller();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sellerlist!=null){
				request.getSession().setAttribute("sellerlist",sellerlist);
			}
			request.getRequestDispatcher("managerseller.jsp").forward(request, response); 
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
