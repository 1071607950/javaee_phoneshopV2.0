package com.city.shop.dao;

import java.util.ArrayList;
import java.util.List;

import com.city.shop.model.Goods;

/**
 * 
 * @author 
 * @category 商品数据库访问接口
 */
public interface IGoodsDao {
	public List<Goods> findAllGoods(String id)throws Exception;

	boolean AddGoods(String id,Goods goods)throws Exception;
	Goods findGoodById(Integer id)throws Exception;
	boolean UpdateGoods(Goods goods,Integer id)throws Exception;
	boolean DeleteGoods(Integer id)throws Exception;
	public int countProject(String sellerId) throws Exception;
	public List<Goods> findGoodByName(String name);
	/**
	 * 全部商品列表
	 */
	public ArrayList<Goods> findAll() throws Exception;
	/**
	 * 通过商品ID获得商品详情
	 */
	public Goods infoGood(int goodId) throws Exception;
	
}
