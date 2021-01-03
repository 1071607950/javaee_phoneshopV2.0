package com.city.shop.service;

import java.util.List;

import com.city.shop.model.Seller;

/**
 * 
 * @author
 * @category 管理员审核逻辑处理接口
 */
public interface IManagerService {
	/**
	 * 审核,退审
	 */
	public Boolean modifyPower(String sellerId, int power) throws Exception;

	/**
	 * 管理员查看所有卖家的列表
	 */
	public List<Seller> lookAllSeller() throws Exception;

	/**
	 * 管理员删除卖家
	 */
	public Boolean delectSeller(String sellerId) throws Exception;
}
