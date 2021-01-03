package com.city.shop.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Goods;
import com.city.shop.model.Seller;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author
 * @category 卖家查看自己的商品前分发
 */
@WebServlet("/pages/seller/togoodlist.do")
public class GoodsTosellergoodslistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsTosellergoodslistController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String role = (String) session.getAttribute("role");
		if(role==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}else if(role.equals("2")){
			Seller seller = (Seller) session.getAttribute("seller");
			String id = seller.getSellerId();


			IGoodsService goodsService = ServiceFactory.createGoodsservice();

				try {
					List<Goods> list = goodsService.findAllGoods(id);

					request.getSession().setAttribute("goodslist", list);
					
					
					request.getRequestDispatcher("/pages/seller/goodlist.jsp").forward(request, response);
				} catch (Exception e) {

					e.printStackTrace();
				}
		}else {
			request.setAttribute("msg", "没有权限访问");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
