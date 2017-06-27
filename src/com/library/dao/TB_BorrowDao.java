package com.library.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.TB_Book;
import com.library.model.TB_Borrow;
import com.library.model.TB_Reader;
import com.library.model.TB_ReaderType;
import com.library.util.DatabaseCon;

public class TB_BorrowDao {
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
	
	//根据rdid查找已借未还书籍
	public List<TB_Borrow> findAllBorrow(int rdId) throws SQLException{
		String sql="select * from TB_Borrow where rdId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, rdId);
		ResultSet rs=ps.executeQuery();
		List<TB_Borrow> borrowList=new ArrayList<TB_Borrow>();
		TB_Borrow borrow=null;
		while(rs.next()){
			if(!rs.getBoolean("isHasReturn")){
//				int rdID;//读者序号
				int bkID=rs.getInt("bkID");//图书序号
				int idContinueTimes=rs.getInt("idContinueTimes");//续借次数
				Date	idDateOut=rs.getDate("idDateOut");//借书日期
				Date idDateRetPlan=rs.getDate("idDateRetPlan");//应还日期
//				Date idDateRetAct;//实际还书日期
//				int idOverDay;//超期天数
//				BigDecimal idOverMoney;//应罚款金额
//				BigDecimal idPunishMoney;//罚款金额
				boolean isHasReturn=rs.getBoolean("isHasReturn");//是否还书
//				String operatorLend;//借书操作员
//				String operatorRet;//还书操作员
				borrow=new TB_Borrow(rdId, bkID, idContinueTimes, idDateOut, idDateRetPlan, isHasReturn);
				borrowList.add(borrow);
			}
		}
		return borrowList;	
	}
	//根据bkId查找书籍
	public TB_Borrow findBookBorrow(int bkId) throws SQLException{
		String sql="select * from TB_Borrow where bkId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,bkId);
		ResultSet rs=ps.executeQuery();
		TB_Borrow borrow=null;
		while(rs.next()){
			if(!rs.getBoolean("isHasReturn")){
				int rdId=rs.getInt("rdId");//读者序号
//				int bkID=rs.getInt("bkID");//图书序号
				int idContinueTimes=rs.getInt("idContinueTimes");//续借次数
				Date	idDateOut=rs.getDate("idDateOut");//借书日期
				Date idDateRetPlan=rs.getDate("idDateRetPlan");//应还日期
//				Date idDateRetAct;//实际还书日期
//				int idOverDay;//超期天数
//				BigDecimal idOverMoney;//应罚款金额
//				BigDecimal idPunishMoney;//罚款金额
				boolean isHasReturn=rs.getBoolean("isHasReturn");//是否还书
//				String operatorLend;//借书操作员
//				String operatorRet;//还书操作员
				borrow=new TB_Borrow(rdId, bkId, idContinueTimes, idDateOut, idDateRetPlan, isHasReturn);
			}
		}
		return borrow;	
	}
	//插入数据，借书
	public int insertBorrow(TB_Borrow borrow) throws SQLException{
		String sql="insert  into TB_Borrow(rdID,bkID, idContinueTimes, idDateOut, idDateRetPlan,isHasReturn,operatorLend) "
				+ "values(?,?,?,?,?,?,?) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, borrow.getRdID());
		ps.setInt(2,borrow.getBkID());
		ps.setInt(3, borrow.getIdContinueTimes());
		ps.setDate(4, borrow.getIdDateOut());//借书日期
//		TB_ReaderDao readerDao=new TB_ReaderDao();
//		TB_Reader reader=readerDao.findReaderById(borrow.getRdID());
//		TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
//		TB_ReaderType type=typeDao.findType(reader.getRdType());
		ps.setDate(5, borrow.getIdDateRetPlan());//应还日期
		ps.setBoolean(6, borrow.isHasReturn());
		ps.setString(7, borrow.getOperatorLend());
		return ps.executeUpdate();	
	}
	//更新书籍是否归还
	public int changBorrow(TB_Borrow borrow) throws SQLException{
		String sql="update TB_Borrow set isHasReturn=?,idDateRetAct=?,idOverDay=?,idOverMoney=?,operatorRet=? where bkId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setBoolean(1, borrow.isHasReturn());
		ps.setDate(2, borrow.getIdDateRetAct());
		ps.setInt(3, borrow.getIdOverDay());
		ps.setBigDecimal(4, borrow.getIdOverMoney());
		ps.setString(5, borrow.getOperatorLend());//还书操作
		ps.setInt(6, borrow.getBkID());
		return ps.executeUpdate();
		
	}
	//续借
	public int nextBorrow(TB_Borrow borrow) throws SQLException{
		String sql="update TB_Borrow set idDateRetPlan=?,operatorLend=?,idContinueTimes=?  where bkId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setDate(1, borrow.getIdDateRetPlan());
		ps.setString(2, borrow.getOperatorLend());
		ps.setInt(3, borrow.getIdContinueTimes()+1);
		ps.setInt(4, borrow.getBkID());
		return ps.executeUpdate();
	}
}
