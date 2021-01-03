package com.city.shop.buyer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.service.IUserService;
import com.city.shop.utils.MdPwdUtil;

/**
 * 
 * @author
 * @category 买家修改密码后处理
 */

@WebServlet("/pages/buyer/buyerchangepass.do")
public class BuyerbuyerchangepassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyerbuyerchangepassController() {
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
			String oldpassword=request.getParameter("oldpassword");
			String newpassword=request.getParameter("newpassword");
			if(buyer.getPassword().equals(MdPwdUtil.MD5Password(oldpassword))){
				buyer.setPassword(MdPwdUtil.MD5Password(newpassword));
				try {
					if(userService.modifyBuyer(buyer)){
						session.setAttribute("buyer", buyer);
						request.setAttribute("msg", "修改成功");
						request.getRequestDispatcher("/pages/buyer/buyerchangepass.jsp").forward(request, response);  
					}else{
						request.setAttribute("msg", "修改失败");  
			            request.getRequestDispatcher("/404.jsp").forward(request, response);  
			            return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", "旧密码错误");  
	            request.getRequestDispatcher("/404.jsp").forward(request, response);  
	            return;
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
