package com.city.shop.model;
/**
 * 
 * @author LZK
 * @category 管理员
 */
public class Manager {
	private String managerId;//管理员ID
	private String password;//管理员密码
	public Manager(String managerId, String password) {
		super();
		this.managerId = managerId;
		this.password = password;
	}
	public Manager() {
		super();
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", password=" + password + "]";
	}
	
}