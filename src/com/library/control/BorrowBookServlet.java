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

import com.library.dao.TB_BookDao;
import com.library.dao.TB_BorrowDao;
import com.library.dao.TB_ReaderDao;
import com.library.dao.TB_ReaderTypeDao;
import com.library.model.TB_Book;
import com.library.model.TB_Borrow;
import com.library.model.TB_Reader;
import com.library.model.TB_ReaderType;

/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet(urlPatterns="/BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookServlet() {
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
			int rdId=(Integer) session.getAttribute("BorrowRdId");
			int bkId=Integer.parseInt(myBkId);
//			int rdId=Integer.parseInt(myRdId);
			TB_BookDao bookDao=new TB_BookDao();
			TB_Book book=bookDao.findBookById(bkId);
			book.setBkStatus("���");
			//
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById(rdId);
			if(reader.getRdStatus().equals("��Ч")){
				int rdBorrowQty=reader.getRdBorrowQty()+1;
				reader.setRdBorrowQty(rdBorrowQty);
				//��ȡӦ��������
				TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
				TB_ReaderType type=typeDao.findType(reader.getRdType());
				TB_BorrowDao borrowDao=new TB_BorrowDao();
				Date idDateOut=new Date(System.currentTimeMillis());
				Date idDateRetPlan=plusDate(idDateOut, type.getCanLendDay());
				int i=(int)session.getAttribute("admin");
				String operatorLend=String.valueOf(i);
				TB_Borrow borrow=new TB_Borrow(rdId, bkId, 0, idDateOut, idDateRetPlan, false,operatorLend);
				borrowDao.insertBorrow(borrow);//�����������
				readerDao.updateReader(reader);//���߽�������һ
				bookDao.changBook(book);//���鼮״̬����Ϊ���
				session.setAttribute("borrowError", "����ɹ�");
			}else{
				session.setAttribute("borrowError", "����ʧ��");
			}
			response.sendRedirect("BorrowFindBookServlet");
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
	
	//Ӧ������
	public Date plusDate(Date date,int day){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		//java.util.Dateתjava.sql.Date
		Date sqlDate=new Date(cal.getTime().getTime());
		return sqlDate;	
	}


}
