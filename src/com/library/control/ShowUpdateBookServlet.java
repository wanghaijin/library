package com.library.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.TB_BookDao;
import com.library.model.TB_Book;

/**
 * Servlet implementation class ShowUpdateBookServlet
 */
@WebServlet("/ShowUpdateBookServlet")
public class ShowUpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session=request.getSession();
			String bkCode=request.getParameter("bkCode");
			TB_BookDao bookDao=new TB_BookDao();
			TB_Book book=bookDao.findBookByCode(bkCode);
			String image=getServletContext().getRealPath("/")+"libraryImage\\book\\"+book.getBkCover();
			book.setBkCover(image);
			session.setAttribute("updateBook", book);
			response.sendRedirect("updateBook.jsp");
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
