package com.library.dao;
import java.math.BigDecimal;
//图书管理数据库操作
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.TB_Book;
import com.library.util.DatabaseCon;

public class TB_BookDao {
	static Connection conn=null;
	static{
		DatabaseCon databaseCon=new DatabaseCon();
		try {
			conn=databaseCon.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查找书籍
	public List<TB_Book> findBook(List<String> column,List<String> info) throws SQLException{
		String sql1="select * from TB_Book ";
		String sql2="select * from TB_Book where ";
		String sql=sql1;
		if(column.size()==0){
			sql=sql1;
		}else{
			for(int i=0;i<column.size();i++){
				if(i!=column.size()-1)
					sql2=sql2+" "+column.get(i)+" "+"like "+" '%"+info.get(i)+"%' "+" and ";
				if(i==column.size()-1)
					sql2=sql2+" "+column.get(i)+" "+"like "+" '%"+info.get(i)+"%' ";
			}
			sql=sql2;
		}
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<TB_Book> book_list=new ArrayList<TB_Book>();
		while(rs.next()){
			int bkId=rs.getInt("bkId");
			String bkCode=rs.getString("bkCode");//图书编号
			String bkName=rs.getString("bkName");//书名
			String bkAuthor=rs.getString("bkAuthor");//作者
			String bkPress=rs.getString("bkPress");//出版社
			Date bkDatePress=rs.getDate("bkDatePress");//出版日期
			String bkISBN=rs.getString("bkISBN");//ISBN书号
			String bkCatalog=rs.getString("bkCatalog");//分类号
			int bkLanguage=rs.getInt("bkLanguage");//语言
			int bkPages=rs.getInt("bkPages");//页数
			BigDecimal bkPrice=rs.getBigDecimal("bkPrice");//价格
			Date bkDateIn=rs.getDate("bkDateIn");//入馆日期
			String bkBrief=rs.getString("bkBrief");//内容介绍
			String bkCover=rs.getString("bkCover");//图书封面照片
			String bkStatus=rs.getString("bkStatus");//图书状态
			TB_Book book=new TB_Book(bkId,bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN, bkCatalog, 
													bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus);
			book_list.add(book);
		}
		return book_list; 	
	}
	
	//新书入库
	public int insertBook(TB_Book book) throws SQLException{
		String sql="insert into TB_Book(bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN,"
				+ " bkCatalog, bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getBkCode());
		ps.setString(2, book.getBkName());
		ps.setString(3, book.getBkAuthor());
		ps.setString(4, book.getBkPress());
		ps.setDate(5, book.getBkDatePress());
		ps.setString(6, book.getBkISBN());
		ps.setString(7,book.getBkCatalog());
		ps.setInt(8, book.getBkLanguage());
		ps.setInt(9, book.getBkPages());
		ps.setBigDecimal(10, book.getBkPrice());
		ps.setDate(11, book.getBkDateIn());
		ps.setString(12, book.getBkBrief());
		ps.setString(13,book.getBkCover());
		ps.setString(14, book.getBkStatus());

		return ps.executeUpdate();	
	}
	
	//书籍维护
	public int updateBook(TB_Book book) throws SQLException{
		String sql="update TB_Book set bkName=?, bkAuthor=?, bkPress=?, bkDatePress=?, bkISBN=?,"
				+ " bkCatalog=?, bkLanguage=?, bkPages=?, bkPrice=?, bkDateIn=?, bkBrief=?, bkCover=?  where bkCode=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getBkName());
		ps.setString(2, book.getBkAuthor());
		ps.setString(3, book.getBkPress());
		ps.setDate(4, book.getBkDatePress());
		ps.setString(5, book.getBkISBN());
		ps.setString(6,book.getBkCatalog());
		ps.setInt(7, book.getBkLanguage());
		ps.setInt(8, book.getBkPages());
		ps.setBigDecimal(9, book.getBkPrice());
		ps.setDate(10, book.getBkDateIn());
		ps.setString(11, book.getBkBrief());
		ps.setString(12,book.getBkCover());
		ps.setString(13, book.getBkCode());
		return ps.executeUpdate();
	}
	//通过ID查找书籍
	public TB_Book findBookById(int bkId) throws SQLException{
		String sql="select * from TB_Book where bkId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, bkId);
		ResultSet rs=ps.executeQuery();
		TB_Book book=null;
		while(rs.next()){
			String bkCode=rs.getString("bkCode");//图书编号
			String bkName=rs.getString("bkName");//书名
			String bkAuthor=rs.getString("bkAuthor");//作者
			String bkPress=rs.getString("bkPress");//出版社
			Date bkDatePress=rs.getDate("bkDatePress");//出版日期
			String bkISBN=rs.getString("bkISBN");//ISBN书号
			String bkCatalog=rs.getString("bkCatalog");//分类号
			int bkLanguage=rs.getInt("bkLanguage");//语言
			int bkPages=rs.getInt("bkPages");//页数
			BigDecimal bkPrice=rs.getBigDecimal("bkPrice");//价格
			Date bkDateIn=rs.getDate("bkDateIn");//入馆日期
			String bkBrief=rs.getString("bkBrief");//内容介绍
			String bkCover=rs.getString("bkCover");//图书封面照片
			String bkStatus=rs.getString("bkStatus");//图书状态
			book=new TB_Book(bkId,bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN, bkCatalog, 
													bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus);
		}
		return book;
	}
	//通过编号查找
	public TB_Book findBookByCode(String bkCode) throws SQLException{
		String sql="select * from TB_Book where bkCode=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, bkCode);
		ResultSet rs=ps.executeQuery();
		TB_Book book=null;
		if(rs.next()){
			int bkId=rs.getInt("bkId");//图书编号
			String bkName=rs.getString("bkName");//书名
			String bkAuthor=rs.getString("bkAuthor");//作者
			String bkPress=rs.getString("bkPress");//出版社
			Date bkDatePress=rs.getDate("bkDatePress");//出版日期
			String bkISBN=rs.getString("bkISBN");//ISBN书号
			String bkCatalog=rs.getString("bkCatalog");//分类号
			int bkLanguage=rs.getInt("bkLanguage");//语言
			int bkPages=rs.getInt("bkPages");//页数
			BigDecimal bkPrice=rs.getBigDecimal("bkPrice");//价格
			Date bkDateIn=rs.getDate("bkDateIn");//入馆日期
			String bkBrief=rs.getString("bkBrief");//内容介绍
			String bkCover=rs.getString("bkCover");//图书封面照片
			String bkStatus=rs.getString("bkStatus");//图书状态
			book=new TB_Book(bkId,bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN, bkCatalog, 
													bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus);
		}
		return book;
	}
	//借还书籍
	public int changBook(TB_Book book) throws SQLException{
		String sql="update TB_Book set  bkStatus=? where bkId=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, book.getBkStatus());
		ps.setInt(2, book.getBkId());
		return ps.executeUpdate();
	}
}
