package com.city.shop.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.model.Manager;
import com.city.shop.model.Seller;
import com.city.shop.service.IUserService;

import com.city.shop.utils.MdPwdUtil;

/**
 * 
 * @author
 * @category 登录后处理
 */
@WebServlet("/user/login.do")
public class UserloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserloginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println( MdPwdUtil.MD5Password(password));
		String rmb = request.getParameter("remember");
		String verifyc = request.getParameter("verifycode");
		String role = request.getParameter("role");
		String svc = (String) request.getSession().getAttribute("sessionverify");
		if(svc==null) {
			request.setAttribute("msg", "验证码异常！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else if (!svc.equalsIgnoreCase(verifyc)) {
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("username", username);
		Cookie usercookie = new Cookie("username", username );
		Cookie passcookie = new Cookie("password", password);
		Cookie checkedcookie = new Cookie("checked", "checked");
		usercookie.setPath("/");// 实现共享
		passcookie.setPath("/");// 实现共享
		checkedcookie.setPath("/");// 实现共享
		if (rmb != null) {
			usercookie.setMaxAge(6000);// 单位是秒
			passcookie.setMaxAge(6000);// 单位是秒
			checkedcookie.setMaxAge(6000);// 单位是秒
		} else {
			usercookie.setMaxAge(0);
			passcookie.setMaxAge(0);
			checkedcookie.setMaxAge(0);
		}
		response.addCookie(usercookie);
		response.addCookie(passcookie);
		response.addCookie(checkedcookie);
		IUserService userService = ServiceFactory.createUserservice();
		// 接收数据
		try {
			// 调用业务逻辑
			if (role.equals("1")) {
				Buyer buyer = userService.loginBuyer(username, password);

				if (buyer != null) {
					request.getSession().setAttribute("buyer", buyer);
					request.getSession().setAttribute("role", role);
					response.getWriter().write("登录成功，1秒后跳转");
					request.getRequestDispatcher("/pages/buyer/buyer.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "用户名或密码错误！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}

			} else if (role.equals("2")) {
				Seller seller = userService.loginSeller(username, password);
				
				if (seller != null) {
					
					request.getSession().setAttribute("seller", seller);
					request.getSession().setAttribute("role", role);
					response.getWriter().write("登录成功，1秒后跳转");
					request.getRequestDispatcher("/pages/seller/seller.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "用户名或密码错误！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
			} else if (role.equals("9")) {
				Manager manager = userService.loginManager(username, password);
				if (manager != null) {
					
					request.getSession().setAttribute("manager", manager);
					request.getSession().setAttribute("role", role);
					response.getWriter().write("登录成功，1秒后跳转");
					request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "用户名或密码错误！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
			} else {
				request.setAttribute("msg", "404未找到错误");
				request.getRequestDispatcher("/404.jsp").forward(request, response);
				return;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
