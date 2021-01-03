package com.city.shop.goods.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.shop.factory.ServiceFactory;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author
 * @category 删除商品后处理
 */
@WebServlet("/pages/seller/deletegoods.do")
public class GoodsdeletegoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsdeletegoodsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String role =(String)session.getAttribute("role");
		if(role==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}else if(role.equals("2")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			IGoodsService goodsService = ServiceFactory.createGoodsservice();
			try {
				if(goodsService.DeleteGoods(id)) {
					request.setAttribute("msg", "删除成功");  
					request.getRequestDispatcher("/pages/seller/togoodlist.do").forward(request, response);  
				}else {
					request.setAttribute("msg", "删除失败");  
					request.getRequestDispatcher("/pages/seller/togoodlist.do").forward(request, response);  
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
