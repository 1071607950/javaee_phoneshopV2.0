package com.city.shop.model;

import java.io.InputStream;


/**
 * 
 * @author LZK
 * @category 商品表
 */
public class Goods {
	private Integer goodId;//商品ID
	private String name;//商品名字
	private String city;//商品产地
	private Integer price;//商品价格
	private Integer number;//商品数量
	private InputStream image;//商品图片
	private String sellerId;//卖家ID
	public Goods(Integer goodId, String name, String city, Integer price, Integer number, InputStream image, String sellerId) {
		super();
		this.goodId = goodId;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.image = image;
		this.sellerId = sellerId;
	}
	public Goods() {
		super();
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	@Override
	public String toString() {
		return "Goods [goodId=" + goodId + ", name=" + name + ", city=" + city + ", price=" + price + ", number="
				+ number + ", image=" + image + ", sellerId=" + sellerId + "]";
	}
}
