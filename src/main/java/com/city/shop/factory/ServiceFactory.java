package com.city.shop.factory;

import com.city.shop.service.IGoodsService;
import com.city.shop.service.IManagerService;
import com.city.shop.service.IOrderService;
import com.city.shop.service.IUserService;
import com.city.shop.service.Impl.GoodsServiceImpl;
import com.city.shop.service.Impl.ManagerServiceImpl;
import com.city.shop.service.Impl.OrderServiceImpl;
import com.city.shop.service.Impl.UserServiceImpl;
/**
 * 
 * @author 
 * @category Service工厂
 */
public class ServiceFactory {
	public static IGoodsService createGoodsservice() {
		return new GoodsServiceImpl();
	}
	public static IManagerService createManagerservice() {
		return new ManagerServiceImpl();
	}
	public static IOrderService createOrderservice() {
		return new OrderServiceImpl();
	}
	public static IUserService createUserservice() {
		return new UserServiceImpl();
	}
}
