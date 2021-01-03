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
 * @category 添加购物车后处理
 */
@WebServlet("/pages/buyer/addshopcart.do")
public class ShopcartaddshopcartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
		String Buyerid=buyer.getBuyerId();
		Integer goodid=Integer.valueOf(request.getParameter("goodId"));
		Integer number=Integer.valueOf(request.getParameter("number"));
		System.out.println(Buyerid+","+goodid+","+number);
		
		Integer[] Goodsid=new Integer[1];
		Goodsid[0]=goodid;
		
		//调用接口
		IUserService userservice=ServiceFactory.createUserservice();
		try {
			userservice.deleteCartGoods_service(Goodsid, Buyerid);
			userservice.addCartGoods_service(Buyerid, goodid, number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//提示添加成功
		request.setAttribute("state", "添加成功");
		//返回商品列表界面
		request.getRequestDispatcher("togoodsinfo.do").forward(request, response);
		
	}
	

}
