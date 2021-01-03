package com.city.shop.unuseservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.model.Orders;
import com.city.shop.service.IOrderService;
import com.city.shop.service.Impl.OrderServiceImpl;

@WebServlet("/ShowOrders")
public class not_ShowOrders extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOrderService orderservie=new OrderServiceImpl();
		String buyerid=request.getParameter("buyerid");
		List<Orders> orderlist=null;
		try {
			orderlist=orderservie.showOrders_service(buyerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("orderlist", orderlist);
		//重定向到订单列表界面
		response.sendRedirect("/jsp/buyer/orders.jsp");
		
	}

	
}
