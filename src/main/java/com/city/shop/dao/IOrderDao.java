package com.city.shop.dao;

import java.util.List;

import com.city.shop.model.OrderView;
import com.city.shop.model.Orders;
import com.city.shop.model.Shopcart;
/**
 * 
 * @author 
 * @category 订单数据库访问接口
 */
public interface IOrderDao {
	
	/**
	 *  通过商家Id查找订单详细信息
	 */
	public List<OrderView> findOrderBySellerId(String sellerId) throws Exception;
	
	/**
	 *  通过买家Id查找订单详细信息
	 */
	public List<OrderView> findOrderByBuyerId(String buyerId) throws Exception;
	/**
	 *  查询卖家订单数量
	 */
	public int OrderSellerIdCount(String sellerId) throws Exception;
	/**
	 *  查询买家订单数量
	 */
	public int OrderBuyerIdCount(String buyerId) throws Exception;
	

	//生成当订单 返回订单Orders集合
	public List<Orders> createOrder(String Date,List<Shopcart> Shopcart) throws Exception;
	//支付订单 
	public boolean payOrder(String Buyerid,int Wallet,Integer[] orderid) throws Exception;
	//查看所有订单 返回订单Orders集合
	public List<Orders> showOrders(String buyerid) throws Exception;
	//查看订单详情  
	public OrderView seeorder(Integer orderid,Integer goodsid,String buyerid) throws Exception;
}
