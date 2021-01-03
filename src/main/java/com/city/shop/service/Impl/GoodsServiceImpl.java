package com.city.shop.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.city.shop.dao.IGoodsDao;
import com.city.shop.dao.ISellerDao;
import com.city.shop.factory.DaoFactory;
import com.city.shop.model.Goods;
import com.city.shop.model.OrderView;
import com.city.shop.model.Seller;
import com.city.shop.service.IGoodsService;

/**
 * 
 * @author 
 * @category 商品逻辑处理接口实现
 */
public class GoodsServiceImpl implements IGoodsService{
	
	public List<Goods> findAllGoods(String id) throws Exception {
		
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		
		List<Goods> goods = goodsDao.findAllGoods(id);
		
		/*if(!goods.isEmpty()&&goods.size()>0) {*/
			return goods;
		/*}else {
			throw new RuntimeException("沒有商品");
		}*/
		
	}

	public boolean AddGoods(String id, Goods goods) throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		return goodsDao.AddGoods(id, goods);
	}

	public Goods findGoodById(Integer id) throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		Goods goods =goodsDao.findGoodById(id);
		return goods;
	}

	public boolean UpdateGoods(Goods goods,Integer id) throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		return goodsDao.UpdateGoods(goods,id);
	}

	public boolean DeleteGoods(Integer id) throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		return goodsDao.DeleteGoods(id);
	}


	public List<Goods> findGoodByName(String name) throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		List<Goods> goods = goodsDao.findGoodByName(name);
		
		/*if(!goods.isEmpty()&&goods.size()>0) {*/
			return goods;
		/*}else {
			throw new RuntimeException("沒有商品");
		}*/
	}
	
	//商品列表
	public ArrayList<Goods> listGood() throws Exception {
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		return goodsDao.findAll();
		// TODO Auto-generated method stub
	}
	
	//商品详情
	public OrderView findByGoodId(int goodId) throws Exception {
		OrderView orderView=new OrderView();
		IGoodsDao goodsDao=DaoFactory.createGoodsDao();
		
		ISellerDao sellerDao=DaoFactory.createSellerDao();
		Goods goods=goodsDao.infoGood(goodId);
		Seller seller=sellerDao.infoGoodSeller(goodId);
		orderView.setGoods(goods);
		orderView.setSeller(seller);
		return orderView;
	}

}
