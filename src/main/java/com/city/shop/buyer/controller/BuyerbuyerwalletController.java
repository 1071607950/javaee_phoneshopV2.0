package com.city.shop.buyer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.service.IUserService;


/**
 * 
 * @author
 * @category 买家钱包后处理
 */

@WebServlet("/pages/buyer/buyerwallet.do")
public class BuyerbuyerwalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuyerbuyerwalletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String role = (String) request.getSession().getAttribute("role");
		String type = request.getParameter("type");
		int money = Integer.valueOf(request.getParameter("money"));
		IUserService userService = ServiceFactory.createUserservice();
		if(role==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}else if(role.equals("1")){
			Buyer buyer = (Buyer) request.getSession().getAttribute("buyer");
			try {
				if (type.equals("1")) {
					if (userService.buyerManagerWallet(buyer.getBuyerId(), money, type)) {
						buyer.setWallet(buyer.getWallet() + money);
						request.setAttribute("msg", "充值成功");
					}else {
						request.setAttribute("msg", "充值失败");
					}
				} else {
					if (money > buyer.getWallet()) {
						request.setAttribute("msg", "余额不足");
						request.getRequestDispatcher("/404.jsp").forward(request, response);
						return;
					}else {
						if (userService.buyerManagerWallet(buyer.getBuyerId(), money, type)) {
							buyer.setWallet(buyer.getWallet() - money);
							request.setAttribute("msg", "提现成功");
						}else {
							request.setAttribute("msg", "提现失败");
						}
					}
				}
				request.getSession().setAttribute("buyer", buyer);
				request.getRequestDispatcher("tobuyerwallet.do").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("msg", "没有权限访问");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
