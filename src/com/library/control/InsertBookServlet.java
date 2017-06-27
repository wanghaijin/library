package com.library.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.TB_BookDao;
import com.library.model.TB_Book;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet(urlPatterns="/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FileOutputStream fout= null;
	private static FileInputStream fin = null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookServlet() {
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
			String bkCode=request.getParameter("bkCode");//ͼ����
			String bkName=request.getParameter("bkName");//����
			String bkAuthor=request.getParameter("bkAuthor");//����
			String bkPress=request.getParameter("bkPress");//������
			String getBkDatePress=request.getParameter("bkDatePress");
//			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
			Date bkDatePress=	Date.valueOf(getBkDatePress);//��������
			String bkISBN=request.getParameter("bkISBN");//ISBN���
			String bkCatalog=request.getParameter("bkCatalog");//�����
			String getBkLanguage=request.getParameter("bkLanguage");
			int bkLanguage=Integer.parseInt(getBkLanguage);//����
			String getBkPages=request.getParameter("bkPages");
			int bkPages=Integer.parseInt(getBkPages);//ҳ��
			String getBkPrice=request.getParameter("bkPrice");
			BigDecimal bkPrice=new BigDecimal(getBkPrice);//�۸�
			Date bkDateIn=new Date(System.currentTimeMillis());
//			Date bkDateIn=(Date) format.parse(format.format(new java.util.Date()));//�������
			String bkBrief=request.getParameter("bkBrief");//���ݽ���
			String getBkCover=request.getParameter("bkCover");//ͼ�������Ƭ
			String bkCover=bkName+".jpg";
			String mybkCover= getServletContext().getRealPath("/")+"/libraryImage/book/"+bkName+".jpg";
			copyImge(getBkCover, mybkCover);//ͼ�������Ƭ���
			String bkStatus="�ڹ�";//ͼ��״̬
			String bkCount=request.getParameter("bkCount");
			int Count=Integer.parseInt(bkCount);
			TB_Book book=new TB_Book(bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN, bkCatalog, bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus);
			TB_BookDao bookDao=new TB_BookDao();
			for(int i=0;i<Count;i++){
			if(bookDao.insertBook(book)!=0){
				session.setAttribute("insertError", "����ɹ�");
			}else{
				session.setAttribute("insertError", "����ʧ��");
			}
			}
			session.setAttribute("bookSize",(int)session.getAttribute("bookSize")+Count);
			response.sendRedirect("insertBook.jsp");
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
