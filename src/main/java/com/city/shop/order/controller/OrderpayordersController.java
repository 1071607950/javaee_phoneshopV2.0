package com.city.shop.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.service.IOrderService;

/**
 * 
 * @category 买家支付订单
 */
@WebServlet("/pages/buyer/payorders.do")
public class OrderpayordersController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOrderService orderservie = ServiceFactory.createOrderservice();
		// 支付订单 参数： 1.用户id 2.用户钱包数 3.订单id数组
		Buyer buyer = (Buyer) request.getSession().getAttribute("buyer");
		String buyerid = buyer.getBuyerId();
		int wallet = buyer.getWallet();

		String StringOrdersid = request.getParameter("ordersid");

		// 处理数据
		Integer[] Ordersid = new Integer[1];

		Ordersid[0] = Integer.valueOf(StringOrdersid);
		
		try {
			orderservie.payOrder_service(buyerid, wallet, Ordersid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 跳转到订单列表

		request.getRequestDispatcher("tobuyerrecord.do").forward(request, response);
	}

}
