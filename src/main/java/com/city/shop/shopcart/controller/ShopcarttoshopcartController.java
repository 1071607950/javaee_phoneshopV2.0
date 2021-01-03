package com.city.shop.shopcart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Buyer;
import com.city.shop.model.Shopcart;
import com.city.shop.service.IUserService;

/**
 * 
 * @author
 * @category 查看购物车前分发
 */
@WebServlet("/pages/buyer/toshopcart.do")
public class ShopcarttoshopcartController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受参数
		Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
		String buyerid=buyer.getBuyerId();
		List<Shopcart> shopcart=new ArrayList<Shopcart>();
		IUserService userservicedao=ServiceFactory.createUserservice();
			try {
				shopcart=userservicedao.seecart_service(buyerid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("shopcart", shopcart);
			request.getRequestDispatcher("/pages/buyer/shopcart.jsp").forward(request, response);
	}
	
	

}
