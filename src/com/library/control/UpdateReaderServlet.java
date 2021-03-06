package com.library.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.TB_ReaderDao;
import com.library.model.TB_Reader;

/**
 * Servlet implementation class UpdateReaderServlet
 */
@WebServlet(urlPatterns="/UpdateReaderServlet")
public class UpdateReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FileOutputStream fout= null;
	private static FileInputStream fin = null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			String getRdId=request.getParameter("rdId");
			int rdId=Integer.parseInt(getRdId);//读者编号
			TB_ReaderDao readerDao=new TB_ReaderDao();
			readerDao.findReaderById(rdId);
			String rdName=request.getParameter("rdName");//姓名
			String rdSex=request.getParameter("rdSex");//性别
			String getRdType=request.getParameter("rdType");
			int rdType=Integer.parseInt(getRdType);//读者类别
			String rdDept=request.getParameter("rdDept");//单位名称
			String rdPhone=request.getParameter("rdPhone");//电话
			String rdEmail=request.getParameter("rdEmail");//电子邮箱
			Date rdDateReg=new Date(System.currentTimeMillis());//读者登记日期
			String rdStatus=null;
			if(readerDao.findReaderById(rdId).getRdBorrowQty()!=0){
				rdStatus=readerDao.findReaderById(rdId).getRdStatus();
			}else{		
				rdStatus=request.getParameter("rdStatus");//证件状态
			}
//		int rdBorrowQty=request.getParameter("rdBorrowQty");//已借书数量
//		String rdPwd=request.getParameter("rdPwd");//读者密码
//		int rdAdminRoles=request.getParameter("rdAdminRoles");//管理角色
			int rdAdminRoles=readerDao.findReaderById(rdId).getRdAdminRoles();
			String getRdPhoto=request.getParameter("rdPhoto");//证件照片
			String rdPhoto=rdId+".jpg";
			String myRdPhoto= getServletContext().getRealPath("/")+"/libraryImage/reader/"+rdId+".jpg";
			copyImge(getRdPhoto, myRdPhoto);//图书封面照片另存
			int rdBorrowQty=readerDao.findReaderById(rdId).getRdBorrowQty();//已借书数量
			String rdPwd=readerDao.findReaderById(rdId).getRdPwd();//读者密码
			TB_Reader reader=new TB_Reader(rdId, rdName, rdSex, rdType, rdDept, rdPhone, rdEmail, rdDateReg, rdPhoto, rdStatus, rdBorrowQty, rdPwd, rdAdminRoles);
			readerDao.updateReader(reader);				
			response.sendRedirect("findReader.jsp");
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
	
	public static void copyImge(String inName,String outName) {
		try {
		fout = new FileOutputStream(outName);//复制文件
		fin = new FileInputStream(inName);//源文件
		byte[] buf = new byte[1024];//缓冲区
		int len = 0;
		while ((len = fin.read(buf)) != -1) {
		fout.write(buf, 0, len);//复制
		}


		} catch (IOException e) {
		e.printStackTrace();
		} finally {
		try {
		if (fin != null)
		fin.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		try {
		if (fout != null)
		fout.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	}
}
