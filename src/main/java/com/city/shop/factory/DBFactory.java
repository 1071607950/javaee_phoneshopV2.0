package com.city.shop.factory;

import java.sql.Connection;

//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * 
 * @author 
 * @category 数据库工厂
 */
public class  DBFactory{
	/*private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	 static {
		 ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
		 	driverClass= bundle.getString("driverClass");
		 	url= bundle.getString("url");
		 	username= bundle.getString("username");
		 	password= bundle.getString("password");
		 	try {
				 Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 			 
	 }*/
	 public static  Connection getConnection() throws SQLException {
		 Context ctx = null;
		 DataSource ds = null;
		 try {
			 ctx = new InitialContext();
			 ds=(DataSource)ctx.lookup("java:comp/env/phoneshopdbcp");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return ds.getConnection();
		
	 }
	 
	 public static void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		 if(rs!=null) {
			 try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 rs=null;
		 }
		 
		 if(stmt!=null) {
			 try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 stmt=null;
		 }
		 
		 if(conn!=null) {
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 conn=null;
		 }
	 }
}
