package com.city.shop.service.Impl;



import java.util.ArrayList;
import java.util.List;

import com.city.shop.dao.IBuyerDao;
import com.city.shop.dao.IManagerDao;
import com.city.shop.dao.ISellerDao;
import com.city.shop.dao.IShopcartDao;
import com.city.shop.dao.Impl.ShopcartDaoImpl;
import com.city.shop.factory.DaoFactory;
import com.city.shop.model.Buyer;
import com.city.shop.model.Manager;
import com.city.shop.model.Seller;
import com.city.shop.model.Shopcart;
import com.city.shop.service.IUserService;


/**
 * 
 * @author 
 * @category 用户业务逻辑处理接口实现
 */

public class UserServiceImpl implements IUserService{
	IBuyerDao buyerdao=DaoFactory.createBuyerDao();
	ISellerDao sellerdao=DaoFactory.createSellerDao();
	IManagerDao managerdao=DaoFactory.createManagerDao();
	public Buyer loginBuyer(String buyerId, String password) throws Exception {
		return buyerdao.findUserByNameAndPassword(buyerId, password);	
	}

	public Seller loginSeller(String sellerId, String password) throws Exception {
		return sellerdao.findUserByNameAndPassword(sellerId, password);
	}

	public Manager loginManager(String managerId, String password) throws Exception {
		// TODO Auto-generated method stub
		return managerdao.findUserByNameAndPassword(managerId, password);
	}

	public Boolean sellerManagerWallet(String sellerId, int money, String type) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		if(type.equals("1")){
			if(sellerDao.addMoney(sellerId, money)){
				return true;
			}
		}else if(type.equals("2")){
			if(sellerDao.reduceMoney(sellerId, money)){
				return true;
			}
		}
		return false;
	}

	public Boolean buyerManagerWallet(String buyerId, int money, String type) throws Exception {
		IBuyerDao buyerDao=DaoFactory.createBuyerDao();
		if(type.equals("1")){
			if(buyerDao.addMoney(buyerId, money)){
				return true;
			}
		}else if(type.equals("2")){
			if(buyerDao.reduceMoney(buyerId, money)){
				return true;
			}
			
		}
		return false;
	}

	public Boolean modifyBuyer(Buyer buyer) throws Exception {
		IBuyerDao buyerDao=DaoFactory.createBuyerDao();
		
		return buyerDao.modifyBuyer(buyer);
	}

	public Boolean modifySeller(Seller seller) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		// TODO Auto-generated method stub
		return sellerDao.modifySeller(seller);
	}

	public Boolean addSeller(Seller seller) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		return sellerDao.addSeller(seller);
	}

	public Boolean addBuyer(Buyer buyer) throws Exception {
		IBuyerDao buyerDao=DaoFactory.createBuyerDao();
		return buyerDao.addBuyer(buyer);
	}

	public Boolean isSeller(Seller seller) throws Exception {
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		return sellerDao.isSeller(seller);
	}

	public Boolean isBuyer(Buyer buyer) throws Exception {
		IBuyerDao buyerDao=DaoFactory.createBuyerDao();
		return buyerDao.isBuyer(buyer);
	}
	
	//查看购物车 参数：buyerid
	public List<Shopcart> seecart_service(String Buyerid) throws Exception {
		// TODO Auto-generated method stub
		IShopcartDao shopcartdao=new ShopcartDaoImpl();
		List<Shopcart> shopcartlist=new ArrayList<Shopcart>();
		shopcartlist=shopcartdao.seecart(Buyerid);
		return shopcartlist;
	}

	//删除购物车  参数：1.商品ID数组  2.用户id
	public boolean deleteCartGoods_service(Integer[] Goodsid, String Buyerid) throws Exception {
		// TODO Auto-generated method stub
		IShopcartDao shopcartdao=new ShopcartDaoImpl();
		boolean state;
		state=shopcartdao.deleteCartGoods(Goodsid, Buyerid);
		return state;
	}

	//添加到购物车
	public boolean addCartGoods_service(String Buyerid,Integer goodid,Integer number) throws Exception {
		// TODO Auto-generated method stub
		Shopcart shopcart=new Shopcart();
		shopcart.setBuyerid(Buyerid);
		shopcart.setGoodsid(goodid);
		shopcart.setNumber(number);
		IShopcartDao shopcartdao=DaoFactory.createShopcartDao();
		return shopcartdao.addCartGoods(shopcart);
	}
	
}
