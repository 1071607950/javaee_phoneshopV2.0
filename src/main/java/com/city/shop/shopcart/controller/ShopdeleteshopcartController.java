package com.city.shop.shopcart.controller;

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
 * @category 删除购物车后处理
 */
@WebServlet("/pages/buyer/deleteshopcart.do")
public class ShopdeleteshopcartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收参数
		String StringGoodsid=request.getParameter("goodsid");
		System.out.println(StringGoodsid);
		Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
		String Buyerid=buyer.getBuyerId();
		//处理数据
		Integer[] Goodsid=new Integer[1];
		
			Goodsid[0]=Integer.valueOf(StringGoodsid);
		
		//调用接口
		IUserService userservice=ServiceFactory.createUserservice();
		try {
			userservice.deleteCartGoods_service(Goodsid, Buyerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("toshopcart.do").forward(request, response);
		
	}

	
	
}
