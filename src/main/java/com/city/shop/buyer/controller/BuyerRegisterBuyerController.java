package com.city.shop.buyer.controller;

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
import com.city.shop.model.Buyer;
import com.city.shop.service.IUserService;
import com.city.shop.utils.MdPwdUtil;

/**
 * 
 * @author
 * @category 卖家注册后处理
 */
@WebServlet("/user/RegisterBuyer.do")
public class BuyerRegisterBuyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerRegisterBuyerController() {
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
		String buyerId=request.getParameter("username");
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
			request.getRequestDispatcher("RegisterBuyer.jsp").forward(request, response);
		} 
		String nickname=request.getParameter("nickname");
		String address=request.getParameter("address");
		
		IUserService us=ServiceFactory.createUserservice();
		Buyer buyer=new Buyer();
		
		buyer.setBuyerId(buyerId);
		buyer.setPassword(MdPwdUtil.MD5Password(password));
		buyer.setEmail(email);
		buyer.setBirthday(date);
		buyer.setNickname(nickname);
		buyer.setAddress(address);
		buyer.setWallet(0);
		try {
			if(us.isBuyer(buyer)){
				request.setAttribute("msg", "用户名已经存在");
				request.getRequestDispatcher("RegisterBuyer.jsp").forward(request, response);
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean b = false;
		try {
			b = us.addBuyer(buyer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			request.getSession().setAttribute("username", buyerId);
			request.getSession().setAttribute("buyer", buyer);
			request.getSession().setAttribute("role","1");
			request.setAttribute("msg", "注册成功");
			request.getRequestDispatcher("/pages/buyer/buyer.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("RegisterBuyer.jsp").forward(request, response);
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
