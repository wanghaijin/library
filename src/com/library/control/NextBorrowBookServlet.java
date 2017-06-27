package com.library.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.library.dao.TB_BorrowDao;
import com.library.dao.TB_ReaderDao;
import com.library.dao.TB_ReaderTypeDao;

import com.library.model.TB_Borrow;
import com.library.model.TB_Reader;
import com.library.model.TB_ReaderType;

/**
 * Servlet implementation class NextBorrowBookServlet
 */
@WebServlet(urlPatterns="/NextBorrowBookServlet")
public class NextBorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextBorrowBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		try {
			String myBkId=request.getParameter("bkId");
			int bkId=Integer.parseInt(myBkId);
			//
			TB_BorrowDao borrowDao=new TB_BorrowDao();
			TB_Borrow borrow=borrowDao.findBookBorrow(bkId);
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById((int)session.getAttribute("BorrowRdId"));
			if(reader.getRdStatus().equals("有效")){	
				TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
				TB_ReaderType type= typeDao.findType(reader.getRdType());		
				Date idDateRetPlan=plusDate(borrow.getIdDateRetPlan(), type.getCanLendDay());
				borrow.setIdDateRetPlan(idDateRetPlan);
				String operatorLend=String.valueOf(session.getAttribute("admin"));
				borrow.setOperatorLend(operatorLend);
				if(type.getCanContinueTimes()>borrow.getIdContinueTimes()){	
					int i=borrowDao.nextBorrow(borrow);
					if(i!=0){
						session.setAttribute("nextBorrowError", "续借成功");
					}else{
						session.setAttribute("nextBorrowError", "续借失败");
					}
				}else{
					session.setAttribute("nextBorrowError", "续借失败");
				}
			}else{
				session.setAttribute("nextBorrowError", "借书证处于无法使用状态");
			}
			response.sendRedirect("BorrowFindReaderServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//应还日期
		public Date plusDate(Date date,int day){
			Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, day);
			//java.util.Date转java.sql.Date
			Date sqlDate=new Date(cal.getTime().getTime());
			return sqlDate;	
		}

}
