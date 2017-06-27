package com.library.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.TB_Reader;
import com.library.util.DatabaseCon;

public class TB_ReaderDao {
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
	
	//根据姓名等信息查找学生信息
	public List<TB_Reader> findReader(List<String> column,List<String> info) throws SQLException{
//		String sql="select * from TB_Reader where ? like '%?%'";
		String sql1="select * from TB_Reader ";
		String sql2="select * from TB_Reader where ";
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
		List<TB_Reader> reader=new ArrayList<TB_Reader	>();
		while(rs.next()){		
			int rdId=rs.getInt("rdId");//读者编号
			String rdName=rs.getString("rdName");//姓名
			String rdSex=rs.getString("rdSex");//性别
			int rdType=rs.getInt("rdType");//读者类别
			String rdDept=rs.getString("rdDept");//单位名称
			String rdPhone=rs.getString("rdPhone");//电话
			String rdEmail=rs.getString("rdEmail");//电子邮箱
			Date rdDateReg=rs.getDate("rdDateReg");//读者登记日期
			String rdPhoto=rs.getString("rdPhoto");//证件照片
			String rdStatus=rs.getString("rdStatus");//证件状态
			int rdBorrowQty=rs.getInt("rdBorrowQty");//已借书数量
			String rdPwd=rs.getString("rdPwd");//读者密码
			int rdAdminRoles=rs.getInt("rdAdminRoles");//管理角色
			TB_Reader read=new TB_Reader(rdId, rdName, rdSex, rdType, rdDept, rdPhone, rdEmail,
					rdDateReg, rdPhoto, rdStatus, rdBorrowQty, rdPwd, rdAdminRoles);
			reader.add(read);			
		}
		return reader;	
	}
	
	//更加ID查找学生信息
	public TB_Reader findReaderById(int rdId) throws SQLException{
		String sql="select * from TB_Reader where rdId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, rdId);
		ResultSet rs=ps.executeQuery();
		TB_Reader reader=null;
		while(rs.next()){
			String rdName=rs.getString("rdName");//姓名
			String rdSex=rs.getString("rdSex");//性别
			int rdType=rs.getInt("rdType");//读者类别
			String rdDept=rs.getString("rdDept");//单位名称
			String rdPhone=rs.getString("rdPhone");//电话
			String rdEmail=rs.getString("rdEmail");//电子邮箱
			Date rdDateReg=rs.getDate("rdDateReg");//读者登记日期
			String rdPhoto=rs.getString("rdPhoto");//证件照片
			String rdStatus=rs.getString("rdStatus");//证件状态
			int rdBorrowQty=rs.getInt("rdBorrowQty");//已借书数量
			String rdPwd=rs.getString("rdPwd");//读者密码
			int rdAdminRoles=rs.getInt("rdAdminRoles");//管理角色
			reader=new TB_Reader(rdId, rdName, rdSex, rdType, rdDept, rdPhone, rdEmail, rdDateReg, rdPhoto, rdStatus, rdBorrowQty, rdPwd, rdAdminRoles);
		}
		return reader;
		
	}
	
	//新生入馆
	public int insertReader(TB_Reader reader) throws SQLException{
		String sql="insert into TB_Reader(rdId,rdName,rdSex,"
				+ "rdType,rdDept,rdPhone,rdEmail,rdDateReg,"
				+ "rdPhoto,rdStatus,rdAdminRoles) "
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, reader.getRdId());
		ps.setString(2, reader.getRdName());
		ps.setString(3, reader.getRdSex());
		ps.setInt(4, reader.getRdType());
		ps.setString(5, reader.getRdDept());
		ps.setString(6, reader.getRdPhone());
		ps.setString(7, reader.getRdEmail());
		ps.setDate(8, reader.getRdDateReg());
		ps.setString(9, reader.getRdPhoto());
		ps.setString(10, reader.getRdStatus());
//		ps.setInt(11, reader.getRdBorrowQty());
//		ps.setString(12, reader.getRdPwd());
		ps.setInt(11, reader.getRdAdminRoles());		
		return ps.executeUpdate();	
	}
	
	//更新读者信息
	public int updateReader(TB_Reader reader) throws SQLException{
		String sql="update TB_Reader set rdName=?,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdEmail=?,rdDateReg=?,rdPhoto=?,"
				+ "rdStatus=?,rdBorrowQty=?,rdPwd=?,rdAdminRoles=? where rdId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, reader.getRdName());
		ps.setString(2, reader.getRdSex());
		ps.setInt(3, reader.getRdType());
		ps.setString(4, reader.getRdDept());
		ps.setString(5, reader.getRdPhone());
		ps.setString(6, reader.getRdEmail());
		ps.setDate(7, reader.getRdDateReg());
		ps.setString(8, reader.getRdPhoto());
		ps.setString(9, reader.getRdStatus());
		ps.setInt(10, reader.getRdBorrowQty());
		ps.setString(11, reader.getRdPwd());
		ps.setInt(12, reader.getRdAdminRoles());	
		ps.setInt(13, reader.getRdId());
		return ps.executeUpdate();
		
	}
}
