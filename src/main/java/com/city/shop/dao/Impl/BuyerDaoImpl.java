package com.city.shop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.city.shop.dao.IBuyerDao;
import com.city.shop.factory.DBFactory;
import com.city.shop.model.Buyer;
import com.city.shop.utils.MdPwdUtil;

/**
 * 
 * @author
 * @category 买家数据库访问接口实现类
 */
public class BuyerDaoImpl implements IBuyerDao {
	public Buyer findUserByNameAndPassword(String buyerId, String password) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Buyer buyer = new Buyer();
		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("select * from buyer where buyerId=? and password=?");
			// 设置参数
			ps.setString(1, buyerId);
			ps.setString(2, MdPwdUtil.MD5Password(password));

			rs = ps.executeQuery();
			if (rs.next()) {

				buyer.setBuyerId(rs.getString("buyerId"));
				buyer.setPassword(rs.getString("password"));
				buyer.setEmail(rs.getString("email"));
				buyer.setBirthday(rs.getDate("birthday"));
				buyer.setAddress(rs.getString("address"));
				buyer.setNickname(rs.getString("nickname"));
				buyer.setWallet(rs.getInt("wallet"));

			} else {
				buyer = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(buyer);
		return buyer;
	}
	
	public Boolean addMoney(String buyerId, int money) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean flag = false;

		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("UPDATE buyer SET wallet=wallet+? where buyerId=?");
			ps.setInt(1, money);
			ps.setString(2, buyerId);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean reduceMoney(String buyerId, int money) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean flag = false;

		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("UPDATE buyer SET wallet=wallet-? where buyerId=?");
			ps.setInt(1, money);
			ps.setString(2, buyerId);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean modifyBuyer(Buyer buyer) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean flag = false;

		try {
			String sql = "UPDATE buyer SET password=?,nickname=?,email=?,birthday=?,address=? WHERE buyerId=?";
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, buyer.getPassword());
			ps.setString(2, buyer.getNickname());
			ps.setString(3, buyer.getEmail());
			// 时间转化
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sf.format(buyer.getBirthday());
			ps.setString(4, date);
			ps.setString(5, buyer.getAddress());
			ps.setString(6, buyer.getBuyerId());
			int i = ps.executeUpdate();
			System.out.println(i);
			flag = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean addBuyer(Buyer buyer) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean flag = false;

		try {
			String sql = "insert into buyer(password,nickname,email,birthday,address,BuyerId) values (?,?,?,?,?,?)";
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, buyer.getPassword());
			ps.setString(2, buyer.getNickname());
			ps.setString(3, buyer.getEmail());
			// 时间转化
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sf.format(buyer.getBirthday());
			ps.setString(4, date);
			ps.setString(5, buyer.getAddress());
			ps.setString(6, buyer.getBuyerId());
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("success");
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean isBuyer(Buyer buyer) throws Exception {
		// 获取链接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean flag = false;

		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("select * from buyer where buyerId=?");
			// 设置参数
			ps.setString(1, buyer.getBuyerId());

			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("用户已经存在");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

}
