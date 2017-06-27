package com.library.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseCon {
		private static String username=null;
		private static String password=null;
		private static String driver=null;
		private static String url=null;
		
		static{
			Properties ps=new Properties();
			try {
				ps.load(DatabaseCon.class.getResourceAsStream("/database.properties"));
				driver=ps.getProperty("driver");
				url=ps.getProperty("url");
				username=ps.getProperty("username");
				password=ps.getProperty("password");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//链接数据库
		public static Connection getCon() throws Exception{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username , password);
			return con;
		}
		//关闭数据库链接
		public static void Close(Connection con) throws SQLException{
			if(con!=null){
				con.close();
			}
		}
}
