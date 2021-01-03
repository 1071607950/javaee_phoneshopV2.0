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
import com.city.shop.model.OrderView;
import com.city.shop.service.IOrderService;

/**
 * @category 买家查看交易记录前分发
 */
@WebServlet("/pages/buyer/tobuyerrecord.do")
public class OrdertobuyerrecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrdertobuyerrecordController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role =(String)request.getSession().getAttribute("role");
		if(role==null) {
			request.setAttribute("msg", "请先登录");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}else if(role.equals("1")){

			Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
			IOrderService orderService=ServiceFactory.createOrderservice();
			try {
				
				List<OrderView> orderBuyerList = orderService.findOrderByBuyerId(buyer.getBuyerId());
				
				if(orderBuyerList!=null){
					request.getSession().setAttribute("orderBuyerList",orderBuyerList);
				}
				
				request.getRequestDispatcher("/pages/buyer/buyerrecord.jsp").forward(request, response); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("msg", "没有权限访问");  
            request.getRequestDispatcher("/404.jsp").forward(request, response);  
            return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
