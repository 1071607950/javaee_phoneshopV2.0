package com.city.shop.goods.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Goods;
import com.city.shop.model.Seller;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author
 * @category 添加商品后处理
 */
@WebServlet("/pages/seller/addgoods.do")
@MultipartConfig
public class GoodsaddgoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsaddgoodsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		Integer price = Integer.valueOf(request.getParameter("price"));
		Integer number = Integer.valueOf(request.getParameter("number"));
		Part part = request.getPart("goodsPic");
		//String fileName=part.getSubmittedFileName(); 
		//String contentType=part.getContentType();
		InputStream image=part.getInputStream(); 
		
		HttpSession session = request.getSession();
		String role =(String)session.getAttribute("role");
		if(role==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}else if(role.equals("2")){
			Seller seller = (Seller) session.getAttribute("seller");
			String sellerid = seller.getSellerId();
			
			IGoodsService goodsService = ServiceFactory.createGoodsservice();
			Goods goods = new Goods(null,name,city,price,number,image,sellerid);
			
			try {
				if(goodsService.AddGoods(sellerid, goods)){
					request.setAttribute("msg", "添加成功");
					request.getRequestDispatcher("/pages/seller/addgoods.jsp").forward(request, response);
				}else{
					request.setAttribute("msg", "添加失败");
					request.getRequestDispatcher("/pages/seller/addgoods.jsp").forward(request, response);
					return;
				}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
