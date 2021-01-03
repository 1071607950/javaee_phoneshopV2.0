package com.city.shop.service.Impl;

import java.util.List;

import com.city.shop.dao.ISellerDao;
import com.city.shop.factory.DaoFactory;
import com.city.shop.model.Seller;
import com.city.shop.service.IManagerService;

/**
 * 
 * @author 
 * @category 管理员审核逻辑处理接口实现
 */
public class ManagerServiceImpl implements IManagerService{
	public List<Seller> lookAllSeller() throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		return sellerDao.findAllSellerInfo();	
	}

	public Boolean modifyPower(String sellerId, int power) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		return sellerDao.toExamine(sellerId, power);
	}

	public Boolean delectSeller(String sellerId) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		return sellerDao.delectSeller(sellerId);
	}

}
