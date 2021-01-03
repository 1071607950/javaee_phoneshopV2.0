package com.city.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.city.shop.model.Goods;
import com.city.shop.model.OrderView;

/**
 * 
 * @author 
 * @category 商品逻辑处理接口
 */
public interface IGoodsService {
	public List<Goods> findAllGoods(String id)throws Exception;
	boolean AddGoods(String id,Goods goods)throws Exception;
	public Goods findGoodById(Integer id) throws Exception;
	boolean UpdateGoods(Goods goods,Integer id)throws Exception;
	boolean DeleteGoods(Integer id)throws Exception;
	public List<Goods> findGoodByName(String name) throws Exception;
	/**
	 * 货物列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Goods> listGood() throws Exception;
	/**
	 * 通过传入商品id获得商品信息和卖家信息
	 */
	public OrderView findByGoodId(int goodId) throws Exception;
}
