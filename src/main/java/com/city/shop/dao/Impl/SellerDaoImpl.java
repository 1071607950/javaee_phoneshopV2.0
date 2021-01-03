package com.city.shop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.city.shop.dao.IGoodsDao;
import com.city.shop.dao.ISellerDao;
import com.city.shop.factory.DBFactory;
import com.city.shop.model.Seller;
import com.city.shop.utils.MdPwdUtil;
/**
 * 
 * @author 
 * @category 卖家数据库访问接口实现类
 */
public class SellerDaoImpl implements ISellerDao{

	public Seller findUserByNameAndPassword(String sellerId, String password) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Seller seller=new Seller();
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from seller where sellerId=? and password=?");
			//设置参数
			ps.setString(1, sellerId);
			ps.setString(2, MdPwdUtil.MD5Password(password));
			
			rs=ps.executeQuery();
			if(rs.next()){
				
				seller.setSellerId(rs.getString("sellerId"));
				seller.setPassword(rs.getString("password"));
				seller.setEmail(rs.getString("email"));
				seller.setBirthday(rs.getDate("birthday"));
				seller.setShopname(rs.getString("shopname"));
				seller.setWallet(rs.getInt("wallet"));
				seller.setPower(rs.getInt("power"));
				
				
			}else{
				seller=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(seller);
		return seller;
	}

	public Boolean addMoney(String sellerId,int money) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
	
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("UPDATE seller SET wallet=wallet+? where sellerId=?");
			ps.setInt(1, money);
			ps.setString(2, sellerId);
			int i=ps.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean reduceMoney(String sellerId,int money) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
	
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("UPDATE seller SET wallet=wallet-? where sellerId=?");
			ps.setInt(1, money);
			ps.setString(2, sellerId);
			int i=ps.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public List<Seller> findAllSellerInfo() throws Exception {
		
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Seller> sellerlist=new ArrayList<Seller>();
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from seller");
			rs=ps.executeQuery();
			while(rs.next()){
				
				Seller seller=new Seller();
				seller.setSellerId(rs.getString("sellerId"));
				seller.setPassword(rs.getString("seller.password"));
				seller.setEmail(rs.getString("seller.email"));
				seller.setBirthday(rs.getDate("seller.birthday"));
				seller.setShopname(rs.getString("shopname"));
				seller.setWallet(rs.getInt("seller.wallet"));
				seller.setPower(rs.getInt("power"));
				sellerlist.add(seller);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(sellerlist);
		return sellerlist;
	}

	public int findAllSellerCount() throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int m=0;
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select COUNT(*) m from seller");
			rs=ps.executeQuery();
		
				
			if (rs.next()) {
				m = rs.getInt("m");
			}
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(m);
		return m;
	}

	public Boolean toExamine(String sellerId, int power) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("UPDATE seller SET power=? where sellerId=?");
			ps.setInt(1, power);
			ps.setString(2, sellerId);
			int i=ps.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean delectSeller(String sellerId) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("DELETE FROM seller where sellerId=?");
			ps.setString(1, sellerId);
			int i=ps.executeUpdate();
			System.out.println("DELETE: " + i);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Seller infoGoodSeller(int goodId) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Seller seller=new Seller();
		IGoodsDao goodsDao=new GoodsDaoImpl();
		if(goodsDao.infoGood(goodId)!=null) {
			seller.setSellerId(goodsDao.infoGood(goodId).getSellerId());
		}
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from seller where sellerId=?");
			ps.setString(1,seller.getSellerId());
			rs=ps.executeQuery();
			if(rs.next()){
				seller.setSellerId(rs.getString("sellerId"));
				seller.setPassword(rs.getString("password"));
				seller.setShopname(rs.getString("shopname"));
				seller.setEmail(rs.getString("email"));
				seller.setBirthday(rs.getDate("birthday"));
				seller.setWallet(rs.getInt("wallet"));
				seller.setPower(rs.getInt("power"));
			}else {
				seller=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(seller);
		return seller;
	}

	public Boolean modifySeller(Seller seller) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
		
		try {
			String sql = "UPDATE seller SET password=?,shopname=?,email=?,birthday=? WHERE sellerId=?";
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, seller.getPassword());
			ps.setString(2, seller.getShopname());
			ps.setString(3, seller.getEmail());
			//时间转化
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sf.format(seller.getBirthday());
			ps.setString(4, date);
			ps.setString(5, seller.getSellerId());
			int i=ps.executeUpdate();
			System.out.println(i);
				flag=true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}

	public Boolean addSeller(Seller seller) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			String sql = "insert into seller(password,shopname,email,birthday,sellerId) values (?,?,?,?,?)";
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, seller.getPassword());
			ps.setString(2, seller.getShopname());
			ps.setString(3, seller.getEmail());
			//时间转化
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sf.format(seller.getBirthday());
			ps.setString(4, date);
			ps.setString(5, seller.getSellerId());
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("success");
				flag=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);

		return flag;
	}

	public Boolean isSeller(Seller seller) throws Exception {
		// 获取链接
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Boolean flag=false;
		
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from seller where sellerId=?");
			//设置参数
			ps.setString(1, seller.getSellerId());
		
			
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
				System.out.println("用户已经存在");
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(flag);
		return flag;
	}		
	
		
	
}
