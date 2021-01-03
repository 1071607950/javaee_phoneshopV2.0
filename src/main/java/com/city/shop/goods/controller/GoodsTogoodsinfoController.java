package com.city.shop.goods.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.OrderView;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author
 * @category 商家和卖家详细信息
 */
@WebServlet("/pages/buyer/togoodsinfo.do")
public class GoodsTogoodsinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IGoodsService goodsService = ServiceFactory.createGoodsservice();
		OrderView orderView=new OrderView();
		int goodId=Integer.valueOf(request.getParameter("goodId"));
		try {
			System.out.println(goodId);
			orderView=goodsService.findByGoodId(goodId);
			System.out.println(orderView);
			if(orderView!=null) {
				request.getSession().setAttribute("sellerGoodsInfoView", orderView);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("goodsinfo.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}