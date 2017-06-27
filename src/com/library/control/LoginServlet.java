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
import com.library.dao.TB_ReaderDao;
import com.library.dao.TB_ReaderTypeDao;
import com.library.model.TB_Book;
import com.library.model.TB_Reader;
import com.library.model.TB_ReaderType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			String str=request.getParameter("username");
			int rdId=Integer.parseInt(str);
			String rdPwd=request.getParameter("pwd");
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById(rdId);
			TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
			List<TB_ReaderType> typeList= typeDao.findAllType();
			if(reader.getRdPwd().equals(rdPwd)){
				TB_BookDao  bookDao=new TB_BookDao();
				List<String> column=new ArrayList<String>();
				List<String> info=new ArrayList<String>();
				List<TB_Book> bookList=bookDao.findBook(column, info);
				session.setAttribute("bookSize", bookList.size()+1);
				session.setAttribute("admin", rdId);
				session.setAttribute("adminTypeList", typeList);//类型列表
				session.setAttribute("adminType", reader.getRdAdminRoles());
				response.sendRedirect("main.jsp");
			}else{
				session.setAttribute("adminType","登录失败!");
				response.sendRedirect("login.jsp");
			}
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
