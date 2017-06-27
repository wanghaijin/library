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
 * Servlet implementation class UpdateAdminRolesServlet
 */
@WebServlet(urlPatterns="/UpdateAdminRolesServlet")
public class UpdateAdminRolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminRolesServlet() {
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
			String myRdAdminRoles=request.getParameter("rdAdminRoles");
			int rdAdminRoles=Integer.parseInt(myRdAdminRoles);
			int rdId=(int) session.getAttribute("adminRdId");
			TB_ReaderDao readerDao=new TB_ReaderDao();
			TB_Reader reader=readerDao.findReaderById(rdId);
			reader.setRdAdminRoles(rdAdminRoles);
			int i=readerDao.updateReader(reader);
			if(i!=0){
				session.setAttribute("adminRolesBoolean","更改成功!");
				//管理部分页面设置
				session.setAttribute("AdminRoles", reader.getRdAdminRoles());
				response.sendRedirect("adminRoles.jsp");
			}else{
				session.setAttribute("adminRolesBoolean","更改失败!");
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
