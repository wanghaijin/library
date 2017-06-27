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
			String bkCode=request.getParameter("bkCode");//图书编号
			String bkName=request.getParameter("bkName");//书名
			String bkAuthor=request.getParameter("bkAuthor");//作者
			String bkPress=request.getParameter("bkPress");//出版社
			String getBkDatePress=request.getParameter("bkDatePress");
//			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
			Date bkDatePress=	Date.valueOf(getBkDatePress);//出版日期
			String bkISBN=request.getParameter("bkISBN");//ISBN书号
			String bkCatalog=request.getParameter("bkCatalog");//分类号
			String getBkLanguage=request.getParameter("bkLanguage");
			int bkLanguage=Integer.parseInt(getBkLanguage);//语言
			String getBkPages=request.getParameter("bkPages");
			int bkPages=Integer.parseInt(getBkPages);//页数
			String getBkPrice=request.getParameter("bkPrice");
			BigDecimal bkPrice=new BigDecimal(getBkPrice);//价格
			Date bkDateIn=new Date(System.currentTimeMillis());
//			Date bkDateIn=(Date) format.parse(format.format(new java.util.Date()));//入馆日期
			String bkBrief=request.getParameter("bkBrief");//内容介绍
			String getBkCover=request.getParameter("bkCover");//图书封面照片
			String bkCover=bkName+".jpg";
			String mybkCover= getServletContext().getRealPath("/")+"/libraryImage/book/"+bkName+".jpg";
			copyImge(getBkCover, mybkCover);//图书封面照片另存
			String bkStatus="在馆";//图书状态
			String bkCount=request.getParameter("bkCount");
			int Count=Integer.parseInt(bkCount);
			TB_Book book=new TB_Book(bkCode, bkName, bkAuthor, bkPress, bkDatePress, bkISBN, bkCatalog, bkLanguage, bkPages, bkPrice, bkDateIn, bkBrief, bkCover, bkStatus);
			TB_BookDao bookDao=new TB_BookDao();
			for(int i=0;i<Count;i++){
			if(bookDao.insertBook(book)!=0){
				session.setAttribute("insertError", "插入成功");
			}else{
				session.setAttribute("insertError", "插入失败");
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
