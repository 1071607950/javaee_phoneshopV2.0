package com.city.shop.buyer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.service.IUserService;

/**
 * 
 * @author
 * @category 买家信息修改后处理
 */

@WebServlet("/pages/buyer/buyermodify.do")
public class BuyermodifybuyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyermodifybuyerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String role =(String)session.getAttribute("role");
		IUserService userService=ServiceFactory.createUserservice();
		if(role==null){
			request.setAttribute("msg", "请先登录");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}else if(role.equals("1")){
			Buyer buyer =(Buyer)session.getAttribute("buyer");
			String birthday=request.getParameter("birthday");
			buyer.setAddress(request.getParameter("address"));
			//字符串转日期
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
			try {
				buyer.setBirthday(sdf1.parse(birthday));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			buyer.setNickname(request.getParameter("nickname"));
			buyer.setEmail(request.getParameter("email"));
			try {
				if(userService.modifyBuyer(buyer)){
					session.setAttribute("buyer", buyer);
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("buyermodify.jsp").forward(request, response);  
				}else{
					request.setAttribute("msg", "修改失败");  
		            request.getRequestDispatcher("/404.jsp").forward(request, response);  
		            return;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("msg", "没有权限访问");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
