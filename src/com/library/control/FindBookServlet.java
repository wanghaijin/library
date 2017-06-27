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
 * Servlet implementation class FindBookServlet
 */
@WebServlet("/FindBookServlet")
public class FindBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookServlet() {
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
			List<String> column=new ArrayList<String>();
			List<String> info=new ArrayList<String>();
			List<TB_Book> bookList=new ArrayList<TB_Book>();
			request.setCharacterEncoding("utf-8");
			String findType=request.getParameter("findType");
			String findInfo=request.getParameter("findInfo");
			if(findInfo!=null){
				column.add(findType);
				info.add(findInfo);
			}else{
				String bkName=request.getParameter("bkName");
				if(!bkName.equals("")){
					column.add("bkName");
					info.add(bkName);
				}
				String bkAuthor=request.getParameter("bkAuthor");
				if(!(bkAuthor.equals(""))){
					column.add("bkAuthor");
					info.add(bkAuthor);
				}
				String bkPress=request.getParameter("bkPress");
				if(!bkPress.equals("")){
					column.add("bkPress");
					info.add(bkPress);
				}
				String bkCatalog=request.getParameter("bkCatalog");
				if(!bkCatalog.equals("")){
					column.add("bkCatalog");
					info.add(bkCatalog);
				}
				String bkDatePress=request.getParameter("bkDatePress");
				if(!bkDatePress.equals("")){
					column.add("bkDatePress");
					info.add(bkDatePress);
				}
			}
			TB_BookDao bookDao=new TB_BookDao();
			bookList=bookDao.findBook(column, info);
			session.setAttribute("findBookList", bookList);
			response.sendRedirect("findBook.jsp");
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
