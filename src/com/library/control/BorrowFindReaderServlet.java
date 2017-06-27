package com.library.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class BorrowServlet
 */
@WebServlet(urlPatterns="/BorrowFindReaderServlet")
public class BorrowFindReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowFindReaderServlet() {
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
					String myRdId=request.getParameter("rdId");
					
					if(myRdId!=null){
						int rdId=Integer.parseInt(myRdId);
						session.setAttribute("BorrowRdId", rdId);
					}
					TB_ReaderDao readerDao=new TB_ReaderDao();
					TB_Reader reader= readerDao.findReaderById((int) session.getAttribute("BorrowRdId"));
					TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
					TB_ReaderType type=typeDao.findType(reader.getRdType());
					TB_BorrowDao borrowDao=new TB_BorrowDao();
					List<TB_Borrow> borrowList=new ArrayList<TB_Borrow>();
					borrowList=borrowDao.findAllBorrow((int) session.getAttribute("BorrowRdId"));
					TB_BookDao bookDao=new TB_BookDao();
					List<TB_Book> bookList=new ArrayList<TB_Book>();
					Date nowDate=new Date(System.currentTimeMillis());
					for(int i=0;i<borrowList.size();i++){
						if(!borrowList.get(i).isHasReturn()){
							int days=differDays(nowDate,borrowList.get(i).getIdDateRetPlan());
							if(days<=0){
								borrowList.get(i).setIdOverDay(0);
								borrowList.get(i).setIdOverMoney(BigDecimal.ZERO);
							}else{
								borrowList.get(i).setIdOverDay(days);
								borrowList.get(i).setIdOverMoney(BigDecimal.valueOf(borrowList.get(i).getIdOverDay()*type.getPunishRate()));
							}

							TB_Book book=bookDao.findBookById(borrowList.get(i).getBkID());
							bookList.add(book);
						}
					}
					session.setAttribute("reader", reader);
					session.setAttribute("type", type);
					session.setAttribute("borrowList", borrowList);
					session.setAttribute("ReturnBookList", bookList);
					response.sendRedirect("borrowBook.jsp");
			
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
