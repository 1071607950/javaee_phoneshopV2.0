package com.city.shop.goods.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.model.Goods;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author
 * @category 卖家查看商品图片前分发
 */
@WebServlet("/pages/seller/goodlistphoto.do")
public class GoodsphototogoodlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsphototogoodlistController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id =Integer.valueOf(request.getParameter("id"));
		
		request.setCharacterEncoding("UTF-8");

		IGoodsService goodsService = ServiceFactory.createGoodsservice();

			try {
				Goods goods = goodsService.findGoodById(id);
				//response.setContentType("image/jpeg");
				OutputStream out=response.getOutputStream();
				InputStream in=goods.getImage();
				int data=0;
				while( (data=in.read())!=-1){
					out.write(data);
				}
				out.flush();
				out.close();
				in.close();
				
			} catch (Exception e) {

				e.printStackTrace();
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
