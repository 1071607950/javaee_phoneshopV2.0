package com.city.shop.factory;

import com.city.shop.dao.IBuyerDao;
import com.city.shop.dao.IGoodsDao;
import com.city.shop.dao.IManagerDao;
import com.city.shop.dao.IOrderDao;
import com.city.shop.dao.ISellerDao;
import com.city.shop.dao.IShopcartDao;
import com.city.shop.dao.Impl.BuyerDaoImpl;
import com.city.shop.dao.Impl.GoodsDaoImpl;
import com.city.shop.dao.Impl.ManagerDaoImpl;
import com.city.shop.dao.Impl.OrderDaoImpl;
import com.city.shop.dao.Impl.SellerDaoImpl;
import com.city.shop.dao.Impl.ShopcartDaoImpl;

/**
 * 
 * @author Administrator
 * @category Dao工厂
 */
public class DaoFactory {
	 public static IBuyerDao createBuyerDao() {
		 return new BuyerDaoImpl();
	 }
	 public static IGoodsDao createGoodsDao() {
		 return new GoodsDaoImpl();
	 }
	 public static IManagerDao createManagerDao() {
		 return new ManagerDaoImpl();
	 }
	 public static IOrderDao createOrderDao() {
		 return new OrderDaoImpl();
	 }
	 public static ISellerDao createSellerDao() {
		 return new SellerDaoImpl();
	 }
	 public static IShopcartDao createShopcartDao() {
		 return new ShopcartDaoImpl();
	 }
}
