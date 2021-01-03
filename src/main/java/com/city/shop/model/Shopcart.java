package com.city.shop.model;
/**
 * 
 * @author LZK
 * @category 购物车
 */
public class Shopcart {
	private String buyerid;//买家ID
	private Goods goods;//商品
	private Integer goodsid;//商品ID
	private Integer number;//数量
	private Integer price;//价格
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Shopcart(String buyerid, Goods goods, Integer goodsid, Integer number, Integer price) {
		super();
		this.buyerid = buyerid;
		this.goods = goods;
		this.goodsid = goodsid;
		this.number = number;
		this.price = price;
	}
	public Shopcart() {
		super();
	}
}
