package com.library.control;

import java.io.IOException;
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
import com.library.model.TB_Book;

/**
 * Servlet implementation class BorrowFindBookServlet
 */
@WebServlet(urlPatterns="/BorrowFindBookServlet")
public class BorrowFindBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowFindBookServlet() {
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
				String bkName=request.getParameter("bkName");
				String myBkId=request.getParameter("bkId");
				session.setAttribute("BorrowBkId", myBkId);
				List<TB_Book> BorrowBookList=new ArrayList<TB_Book>();
				if(myBkId==null||myBkId.equals("")){
					List<String> column=new ArrayList<String>();
					column.add("bkName");
					List<String> info=new ArrayList<String>();
					info.add(bkName);
					TB_BookDao bookDao=new TB_BookDao();
					BorrowBookList=bookDao.findBook(column, info);
				}else{
					int bkId=Integer.parseInt((String)session.getAttribute("BorrowBkId"));
					TB_BookDao bookDao=new TB_BookDao();
					TB_Book book=bookDao.findBookById(bkId);
					BorrowBookList.add(book);
				}
					//判断书是否在馆
					for(int i=0;i<BorrowBookList.size();i++){
						if(BorrowBookList.get(i)!=null){	
							Boolean bool=BorrowBookList.get(i).getBkStatus().equals("在馆");
							if(!bool){
								BorrowBookList.remove(i);
								i--;
							}
							session.setAttribute("BorrowBookList", BorrowBookList);
						}else{
							
							session.setAttribute("findBorrowError", "此书不在馆");
					}
				}
				session.setAttribute("BorrowBkName", bkName);
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

}
