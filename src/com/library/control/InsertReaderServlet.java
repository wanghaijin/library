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
import javax.servlet.http.HttpSession;

import com.library.dao.TB_ReaderDao;
import com.library.model.TB_Reader;

/**
 * Servlet implementation class InsertReaderServlet
 */
@WebServlet(urlPatterns="/InsertReaderServlet")
public class InsertReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FileOutputStream fout= null;
	private static FileInputStream fin = null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReaderServlet() {
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
			request.setCharacterEncoding("utf-8");
			String getRdId=request.getParameter("rdId");
			int rdId=Integer.parseInt(getRdId);//���߱��
			String rdName=request.getParameter("rdName");//����
			String rdSex=request.getParameter("rdSex");//�Ա�
			String getRdType=request.getParameter("rdType");
			int rdType=Integer.parseInt(getRdType);//�������
			String rdDept=request.getParameter("rdDept");//��λ����
			String rdPhone=request.getParameter("rdPhone");//�绰
			String rdEmail=request.getParameter("rdEmail");//��������
			Date rdDateReg=new Date(System.currentTimeMillis());//���ߵǼ�����
			String rdStatus="��Ч";//֤��״̬
//		int rdBorrowQty=request.getParameter("rdBorrowQty");//�ѽ�������
//		String rdPwd=request.getParameter("rdPwd");//��������
//		int rdAdminRoles=request.getParameter("rdAdminRoles");//�����ɫ
			String getRdAdminRoles=request.getParameter("rdAdminRoles");
			int rdAdminRoles=Integer.parseInt(getRdAdminRoles);
			String getRdPhoto=request.getParameter("rdPhoto");//֤����Ƭ
			String rdPhoto=rdId+".jpg";
			String myRdPhoto= getServletContext().getRealPath("/")+"/libraryImage/reader/"+rdId+".jpg";
			copyImge(getRdPhoto, myRdPhoto);//ͼ�������Ƭ���
			int rdBorrowQty=0;//�ѽ�������
			String rdPwd="123";//��������
			TB_Reader reader=new TB_Reader(rdId, rdName, rdSex, rdType, rdDept, rdPhone, rdEmail, rdDateReg, rdPhoto, rdStatus, rdBorrowQty, rdPwd, rdAdminRoles);
			TB_ReaderDao readerDao=new TB_ReaderDao();
			if(readerDao.insertReader(reader)!=0){
				session.setAttribute("insertError", "����ɹ�");
			}else{
				session.setAttribute("insertError", "����ʧ��");
			}
			response.sendRedirect("insertReader.jsp");
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
		fout = new FileOutputStream(outName);//�����ļ�
		fin = new FileInputStream(inName);//Դ�ļ�
		byte[] buf = new byte[1024];//������
		int len = 0;
		while ((len = fin.read(buf)) != -1) {
		fout.write(buf, 0, len);//����
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
