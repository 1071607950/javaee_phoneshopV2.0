package com.city.shop.seller.controller;

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
import com.city.shop.model.Seller;
import com.city.shop.service.IUserService;

/**
 * 
 * @author
 * @category 卖家信息修改后处理
 */

@WebServlet("/pages/seller/sellermodify.do")
public class SellermodifysellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellermodifysellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		}else if(role.equals("2")){
			Seller seller =(Seller)session.getAttribute("seller");
			String birthday=request.getParameter("birthday");
			//字符串转日期
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				seller.setBirthday(sdf1.parse(birthday));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			seller.setShopname(request.getParameter("shopname"));
			seller.setEmail(request.getParameter("email"));
			try {
				if(userService.modifySeller(seller)){
					session.setAttribute("seller", seller);
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("sellermodify.jsp").forward(request, response);  
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
