package com.library.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.TB_BookDao;
import com.library.dao.TB_BorrowDao;
import com.library.dao.TB_ReaderDao;
import com.library.dao.TB_ReaderTypeDao;
import com.library.model.TB_Book;
import com.library.model.TB_Borrow;
import com.library.model.TB_Reader;
import com.library.model.TB_ReaderType;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet(urlPatterns="/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
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
			TB_BookDao bookDao=new TB_BookDao();
			TB_Book book=bookDao.findBookById(bkId);
			book.setBkStatus("在馆");
			bookDao.changBook(book);
			//
			TB_BorrowDao borrowDao=new TB_BorrowDao();
			TB_Borrow borrow=borrowDao.findBookBorrow(bkId);
			borrow.setHasReturn(true);
			borrow.setIdDateRetAct(new Date(System.currentTimeMillis()));
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById((int)session.getAttribute("BorrowRdId"));
			int days=differDays(borrow.getIdDateRetAct(),borrow.getIdDateRetPlan());
			TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
			TB_ReaderType type= typeDao.findType(reader.getRdType());		
			if(days<=0){
				borrow.setIdOverDay(0);
				borrow.setIdOverMoney(BigDecimal.ZERO);
			}else{
				borrow.setIdOverDay(days);
				borrow.setIdOverMoney(BigDecimal.valueOf(borrow.getIdOverDay()*type.getPunishRate()));
			}
			String operatorLend=String.valueOf((int)session.getAttribute("admin"));
			borrow.setOperatorLend(operatorLend);//还书管理员
			borrowDao.changBorrow(borrow);
			int rdBorrowQty=reader.getRdBorrowQty()-1;
			reader.setRdBorrowQty(rdBorrowQty);
			readerDao.updateReader(reader);
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

	//两日期相差
	public int differDays(Date idDateRetAct,Date idDateRetPlan){
		java.util.Date date1=new java.util.Date(idDateRetAct.getTime());
		java.util.Date date2=new java.util.Date(idDateRetPlan.getTime());
		int days=(int)((date1.getTime()-date2.getTime())/(24*60*60*1000));
		return days;	
	}
}
