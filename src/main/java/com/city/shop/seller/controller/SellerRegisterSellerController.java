package com.city.shop.seller.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Seller;
import com.city.shop.service.IUserService;
import com.city.shop.utils.MdPwdUtil;

/**
 * 
 * @author
 * @category 卖家注册后处理
 */
@WebServlet("/user/RegisterSeller.do")
public class SellerRegisterSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerRegisterSellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//接受数据
		String sellerId=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String birthday=request.getParameter("birthday");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "生日格式不对");
			request.getRequestDispatcher("RegisterSeller.jsp").forward(request, response);
		} 
		String shopname=request.getParameter("shopname");
		
		IUserService us=ServiceFactory.createUserservice();
		Seller seller=new Seller();
		seller.setSellerId(sellerId);
		seller.setPassword(MdPwdUtil.MD5Password(password));
		seller.setEmail(email);
		seller.setBirthday(date);
		seller.setShopname(shopname);
		seller.setWallet(0);
		try {
			if(us.isSeller(seller)){
				request.setAttribute("msg", "用户名已经存在");
				request.getRequestDispatcher("RegisterSeller.jsp").forward(request, response);
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean b = false;
		try {
			b = us.addSeller(seller);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			request.getSession().setAttribute("username", sellerId);
			request.getSession().setAttribute("seller", seller);
			request.getSession().setAttribute("role","2");
			request.setAttribute("msg", "注册成功");
			request.getRequestDispatcher("/pages/seller/seller.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("RegisterSeller.jsp").forward(request, response);
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
