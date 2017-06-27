package com.library.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.TB_ReaderDao;
import com.library.model.TB_Reader;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet(urlPatterns="/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
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
			String myRdId=request.getParameter("rdId");
			int rdId=Integer.parseInt(myRdId);
			int passType=(int) session.getAttribute("admin");
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById(rdId);
			if(rdId==passType){
				String rdPwd=request.getParameter("rdPwd");
				reader.setRdPwd(rdPwd);
			}else{
				String rdPwd="123";
				reader.setRdPwd(rdPwd);
			}
			readerDao.updateReader(reader);
			if(rdId==passType){
				session.setAttribute("myPassword", "成功更改");
				response.sendRedirect("myPassword.jsp");
			}else{
				session.setAttribute("Password", "重置成功");
				response.sendRedirect("password.jsp");
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
