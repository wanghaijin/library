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

import com.library.dao.TB_ReaderDao;
import com.library.model.TB_Reader;

/**
 * Servlet implementation class FindReaderServlet
 */
@WebServlet(urlPatterns="/FindReaderServlet")
public class FindReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindReaderServlet() {
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
		List<TB_Reader> readerList=new ArrayList<TB_Reader>();
		request.setCharacterEncoding("utf-8");
		String rdType=request.getParameter("rdType");
		if(!rdType.equals("")){
			column.add("rdType");
			info.add(rdType);
		}
		String rdDept=request.getParameter("rdDept");
		if(!rdDept.equals("")){
			column.add("rdDept");
			info.add(rdDept);
		}
		String rdName=request.getParameter("rdName");
		if(!rdName.equals("")){
			column.add("rdName");
			info.add(rdName);
		}
		TB_ReaderDao readerDao=new TB_ReaderDao();		
			readerList=readerDao.findReader(column, info);
			session.setAttribute("readerList",readerList);
			request.getRequestDispatcher("findReader.jsp").forward(request, response);
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
