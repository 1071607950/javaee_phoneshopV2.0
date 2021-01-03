package com.city.shop.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author
 * @category 注销后处理
 */
@WebServlet("/user/loginOut.do")
public class UserloginOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserloginOutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie usercookie = new Cookie("username", "");
		Cookie passcookie = new Cookie("password", "");
		Cookie checkedcookie = new Cookie("checked", "");
		usercookie.setPath("/");
		passcookie.setPath("/");
		checkedcookie.setPath("/");
		usercookie.setMaxAge(0);
		passcookie.setMaxAge(0);
		checkedcookie.setMaxAge(0);
		response.addCookie(usercookie);
		response.addCookie(passcookie);
		response.addCookie(checkedcookie);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
