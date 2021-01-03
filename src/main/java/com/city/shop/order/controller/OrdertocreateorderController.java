package com.city.shop.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.model.Orders;
import com.city.shop.service.IOrderService;
import com.city.shop.service.IUserService;


/**
 * @category 买家创建订单前分发
 */
@WebServlet("/pages/buyer/tocreateorder.do")
public class OrdertocreateorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 生成当订单 参数：1.商品id数组 2.用户id
		// 接收参数
		Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
		String buyerid=buyer.getBuyerId();

		String StringGoodsid = request.getParameter("Goodsid");

		// 处理数据
		Integer[] Goodsid = new Integer[1];
		
			Goodsid[0] = Integer.valueOf(StringGoodsid);
		

		// 调用接口
		IOrderService orderservie=ServiceFactory.createOrderservice();
		IUserService userservice=ServiceFactory.createUserservice();
		List<Orders> orders=null;
		try {
			orders=	orderservie.createOrder_service(Goodsid, buyerid);
			userservice.deleteCartGoods_service(Goodsid, buyerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//保存数据
		request.getSession().setAttribute("orders", orders);
		//转发
		
		 request.getRequestDispatcher("/pages/buyer/createorder.jsp").forward(request, response);  
	}

}
