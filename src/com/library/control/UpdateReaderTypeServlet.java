package com.library.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.library.dao.TB_ReaderTypeDao;
import com.library.model.TB_ReaderType;

/**
 * Servlet implementation class UpdateReaderServlet
 */
@WebServlet(urlPatterns="/UpdateReaderTypeServlet")
public class UpdateReaderTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReaderTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			 request.setCharacterEncoding("UTF-8");
			 String myRdType=request.getParameter("rdType");
			 int rdType=Integer.parseInt(myRdType);
			 String myTypeListName="typeListName"+myRdType;
			 String myTypeListQty="typeListQty"+rdType;
			 String myTypeListDay="typeListDay"+rdType;
			 String myTypeListTimes="typeListTimes"+rdType;
			 String myTypeListRate="typeListRate"+rdType;
			 String myTypeListDate="typeListDate"+rdType;
			 String rdTypeName=request.getParameter(myTypeListName);//读者名称
			 String myCanLendQty=request.getParameter(myTypeListQty);
			 int canLendQty=Integer.parseInt(myCanLendQty);//可借书数量
			 String myCanLendDay=request.getParameter(myTypeListDay);
			 int canLendDay=Integer.parseInt(myCanLendDay);//可借书天数
			 String myCanContinueTimes=request.getParameter(myTypeListTimes);
			 int canContinueTimes=Integer.parseInt(myCanContinueTimes);//可续借次数
			 String myPunishRate=request.getParameter(myTypeListRate);
			 float punishRate=Float.parseFloat(myPunishRate);//罚款率
			 String myDateValid=request.getParameter(myTypeListDate);
			 int dateValid=Integer.parseInt(myDateValid);//证书有效期
			 TB_ReaderType type=new TB_ReaderType(rdType, rdTypeName, canLendQty, canLendDay, canContinueTimes, punishRate, dateValid);
			 TB_ReaderTypeDao typeDao=new TB_ReaderTypeDao();
			 int i=typeDao.updateType(type);
			 if(i!=0){
				 request.getSession().setAttribute("updateType","更新成功");
				 response.sendRedirect("FindReaderTypeServlet");
			 }else{
				 System.out.println("更改失败");
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
