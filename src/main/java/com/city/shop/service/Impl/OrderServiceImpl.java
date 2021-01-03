package com.city.shop.service.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.city.shop.dao.IOrderDao;
import com.city.shop.factory.DBFactory;
import com.city.shop.factory.DaoFactory;
import com.city.shop.model.OrderView;
import com.city.shop.model.Orders;
import com.city.shop.model.Shopcart;
import com.city.shop.service.IOrderService;

/**
 * 
 * @author
 * @category 订单逻辑处理接口实现
 */
public class OrderServiceImpl implements IOrderService {

	public List<OrderView> findOrderBySellerId(String sellerId) throws Exception {
		IOrderDao orderDao = DaoFactory.createOrderDao();
		return orderDao.findOrderBySellerId(sellerId);
	}

	public List<OrderView> findOrderByBuyerId(String buyerId) throws Exception {
		IOrderDao orderDao = DaoFactory.createOrderDao();
		return orderDao.findOrderByBuyerId(buyerId);
	}

	// 生成订单
	public List<Orders> createOrder_service(Integer[] Goodsid, String Buyerid) throws Exception {
		// TODO Auto-generated method stub
		// 数据接受与处理
		// 1.时间的接受
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		// 2.List<Shopcart> Shopcart的接受
		List<Shopcart> shopcartlist = new ArrayList<Shopcart>();
		Shopcart shopcart = null;
		String buyerid = Buyerid;
		Integer[] goodsid = Goodsid;
		Connection conn = DBFactory.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = null;
		for (Integer goodsidlist : goodsid) {
			shopcart = new Shopcart();
			String sql = "select number from shopcart where buyerId='" + buyerid + "' and goodId=" + goodsidlist + "";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				shopcart.setBuyerid(buyerid);
				shopcart.setGoodsid(goodsidlist);
				shopcart.setNumber(rs.getInt(1));
			}
			String sql2 = "select price from goods where goodId=" + goodsidlist + "";
			rs = st.executeQuery(sql2);
			if (rs.next()) {
				shopcart.setPrice(rs.getInt(1));
			}
			shopcartlist.add(shopcart);
		}
		// 调用DAO层方法操作操作
		IOrderDao orderDao = DaoFactory.createOrderDao();
		System.out.println("时间" + date);
		System.out.println(shopcartlist);
		List<Orders> orderlist = orderDao.createOrder(date, shopcartlist);
		for (Orders orders : orderlist) {
			System.out.println("输出订单号");
			System.out.println(orders.getOrderid());
		}
		return orderlist;
	}

	// 支付订单
	public boolean payOrder_service(String Buyerid, int Wallet, Integer[] orderid) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao orderDao = DaoFactory.createOrderDao();
		return orderDao.payOrder(Buyerid, Wallet, orderid);
	}

	// 查看所有订单
	public List<Orders> showOrders_service(String buyerid) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao orderDao = DaoFactory.createOrderDao();
		List<Orders> orderlist = orderDao.showOrders(buyerid);
		return orderlist;
	}

	// 查看订单详情
	public OrderView seeorder_service(Integer orderid, Integer goodsid, String buyerid) throws Exception {
		// TODO Auto-generated method stub
		IOrderDao orderDao = DaoFactory.createOrderDao();
		OrderView orderView = orderDao.seeorder(orderid, goodsid, buyerid);
		return orderView;
	}

}
