package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.TB_ReaderType;
import com.library.util.DatabaseCon;

public class TB_ReaderTypeDao {
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
	
	//查找全部类型
	public List<TB_ReaderType> findAllType() throws SQLException{
		String sql="select * from TB_ReaderType";
		PreparedStatement ps=conn.prepareStatement(sql);
		List<TB_ReaderType> typeList=new ArrayList<TB_ReaderType>();
		ResultSet rs=ps.executeQuery();
		TB_ReaderType type;
		while(rs.next()){
			 int rdType=rs.getInt("rdType");//读者类别
			 String rdTypeName=rs.getString("rdTypeName");//类别名称
			 int canLendQty=rs.getInt("canLendQty");//可借书数量
			 int canLendDay=rs.getInt("canLendDay");//可借书天数
			 int canContinueTimes=rs.getInt("canContinueTimes");//可续借次数
			 float punishRate=rs.getFloat("punishRate");//罚款率
			 int dateValid=rs.getInt("dateValid");//证书有效期
			type=new TB_ReaderType(rdType, rdTypeName, canLendQty, canLendDay, canContinueTimes, punishRate, dateValid);
			typeList.add(type);
		}
		return typeList;
	}
	//查找对应类型
	public TB_ReaderType findType(int rdType) throws SQLException{
		String sql="select * from TB_ReaderType where rdType=?";	
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, rdType);
		ResultSet rs=ps.executeQuery();
		TB_ReaderType type = null;
		while(rs.next()){
//			 int rdType=rs.getInt("rdType");//读者类别
			 String rdTypeName=rs.getString("rdTypeName");//类别名称
			 int canLendQty=rs.getInt("canLendQty");//可借书数量
			 int canLendDay=rs.getInt("canLendDay");//可借书天数
			 int canContinueTimes=rs.getInt("canContinueTimes");//可续借次数
			 float punishRate=rs.getFloat("punishRate");//罚款率
			 int dateValid=rs.getInt("dateValid");//证书有效期
			type=new TB_ReaderType(rdType, rdTypeName, canLendQty, canLendDay, canContinueTimes, punishRate, dateValid);
		}
		return type;
	}
	
	//更新类型数据
	public int updateType(TB_ReaderType type) throws SQLException	{
		String sql="update TB_ReaderType set rdTypeName=? , canLendQty=?,"
				+ "canLendDay=?,canContinueTimes=?,punishRate=?,dateValid=? where rdType=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, type.getRdTypeName());
		ps.setInt(2, type.getCanLendQty());
		ps.setInt(3, type.getCanLendDay());
		ps.setInt(4, type.getCanContinueTimes());
		ps.setFloat(5, type.getPunishRate());
		ps.setInt(6, type.getDateValid());
		ps.setInt(7, type.getRdType());
		return ps.executeUpdate();	
	}
}
