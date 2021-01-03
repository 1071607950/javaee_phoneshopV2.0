package com.city.shop.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.shop.dao.IGoodsDao;
import com.city.shop.factory.DBFactory;
import com.city.shop.model.Goods;
/**
 * 
 * @author
 * @category 商品数据库访问接口实现类
 */

public class GoodsDaoImpl implements IGoodsDao {

	public List<Goods> findAllGoods(String id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();

		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("select * from goods where sellerId=?");

			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodId(rs.getInt("goodId"));
				goods.setName(rs.getString("name"));
				goods.setCity(rs.getString("city"));
				goods.setPrice(rs.getInt("price"));
				goods.setNumber(rs.getInt("number"));
				goods.setImage(rs.getBinaryStream("image"));
				list.add(goods);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}

		return list;
	}

	public boolean AddGoods(String id, Goods goods) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = DBFactory.getConnection();
			String sql = "INSERT INTO goods(name,city,price,number,sellerId,image) VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getCity());
			ps.setInt(3, goods.getPrice());
			ps.setInt(4, goods.getNumber());
			ps.setString(5, id);
			ps.setBinaryStream(6, goods.getImage(),goods.getImage().available());
			int rows = ps.executeUpdate();

			if (rows == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		return result;

	}
	
	public Goods findGoodById(Integer id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods goods = new Goods();
		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("select * from goods where goodId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				goods.setGoodId(rs.getInt("goodId"));
				goods.setName(rs.getString("name"));
				goods.setCity(rs.getString("city"));
				goods.setPrice(rs.getInt("price"));
				goods.setNumber(rs.getInt("number"));
				goods.setImage(rs.getBinaryStream("image"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}

		return goods;
	}

	public boolean UpdateGoods(Goods goods, Integer id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "UPDATE goods SET name=?,city=?,price=?,number=?,image=? WHERE goodId=?";
		String sql2 = "UPDATE goods SET name=?,city=?,price=?,number=? WHERE goodId=?";
		Connection connection = DBFactory.getConnection();
		connection.setAutoCommit(false);
		try {
			if (goods.getImage() != null) {
				ps = connection.prepareStatement(sql);
				ps.setString(1, goods.getName());
				ps.setString(2, goods.getCity());
				ps.setInt(3, goods.getPrice());
				ps.setInt(4, goods.getNumber());
				ps.setBinaryStream(5, goods.getImage());
				ps.setInt(6, id);
				ps.executeUpdate();
				connection.commit();
				return true;
			} else {
				ps = connection.prepareStatement(sql2);
				ps.setString(1, goods.getName());
				ps.setString(2, goods.getCity());
				ps.setInt(3, goods.getPrice());
				ps.setInt(4, goods.getNumber());
				ps.setInt(5, id);
				ps.executeUpdate();
				connection.commit();
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}
		return false;

	}

	public boolean DeleteGoods(Integer id) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "delete from goods where goodId=?";
			connection = DBFactory.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			// 执行sql语句
			ps.executeUpdate();
			// 事务提交
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBFactory.closeAll(rs, ps, connection);
		}
		return true;
	}

	

	public int countProject(String sellerId) throws Exception {
		String sql = "SELECT COUNT(*) m FROM goods where sellerId=?";

		Connection connection = DBFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, sellerId);
			rs = ps.executeQuery();
			int m = 0;
			if (rs.next()) {
				m = rs.getInt("m");
				return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, connection);
		}
		return -1;
	}

	public List<Goods> findGoodByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = DBFactory.getConnection();
			ps = conn.prepareStatement("select * from goods where name=?");
			ps.setString(1, name);

			rs = ps.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodId(rs.getInt("goodId"));
				goods.setName(rs.getString("name"));
				goods.setCity(rs.getString("city"));
				goods.setPrice(rs.getInt("price"));
				goods.setNumber(rs.getInt("number"));
				goods.setImage(rs.getBinaryStream("image"));
				list.add(goods);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBFactory.closeAll(rs, ps, conn);
		}

		return list;
	}
	
	
	public ArrayList<Goods> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods> list=new ArrayList<Goods>();
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from goods");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods good=new Goods();
				good.setGoodId(rs.getInt("goodId"));
				good.setName(rs.getString("name"));
				good.setCity(rs.getString("city"));
				good.setPrice(rs.getInt("price"));
				good.setNumber(rs.getInt("number"));
				good.setImage(rs.getBinaryStream("image"));
				good.setSellerId(rs.getString("sellerId"));
				list.add(good);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBFactory.closeAll(rs, ps, conn);
		}	
		System.out.println(list);
		return list;
	}
	/**
	 * 商品详情
	 * @return
	 * @throws Exception
	 */
 
	public Goods infoGood(int goodId) throws Exception{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods good=new Goods();
		try {
			conn=DBFactory.getConnection();
			ps=conn.prepareStatement("select * from goods where goodId=?");
			ps.setInt(1,goodId);
			rs=ps.executeQuery();
			if(rs.next()){
				good.setGoodId(rs.getInt("goodId"));
				good.setName(rs.getString("name"));
				good.setCity(rs.getString("city"));
				good.setPrice(rs.getInt("price"));
				good.setNumber(rs.getInt("number"));
				good.setImage(rs.getBinaryStream("image"));
				good.setSellerId(rs.getString("sellerId"));
			}else {
				good=null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBFactory.closeAll(rs, ps, conn);
		}
		System.out.println(good);
		return good;
	}

}
