<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查找书籍</title>
</head>
<body>
<form>
	<table width="900px" align="center">
	<tr>
		<td><input type="button" value="书籍查找" onclick="location='findBook.jsp'"/></td>
		<td><input type="button" value="密码更改" onclick="location='myPassword.jsp'"/></td>
		<c:if test="${adminType==1||adminType==0 }">
		<td><input type="button"id="reader"value="读者查找" onclick="location='findReader.jsp'"/></td>
		<td><input type="button" id="reader" value="新生入馆" onclick="location='insertReader.jsp'"/></td>
		<td><input type="button" id="reader"value="信息更改" onclick="location='findReader.jsp'"/></td>
		<td><input type="button" id="reader"value="类别管理" onclick="location='FindReaderTypeServlet'"/></td>
		<td><input type="button" value="重置密码" onclick="location='password.jsp'"/></td>
		</c:if>
		<c:if test="${adminType==2||adminType==0 }">
		<td><input type="button" id="book" value="新书入库" onclick="location='insertBook.jsp'"/></td>
		<td><input type="button" id="book" value="图书维护" onclick="location='findBook.jsp'"/></td>
		</c:if>
		<c:if test="${adminType==3||adminType==0 }">
		<td><input type="button" id="borrow"value="借阅管理" onclick="location='borrowBook.jsp'"/></td>
		</c:if>
		<c:if test="${adminType==0 }">
				<td><input type="button" value="权限管理" onclick="location='adminRoles.jsp'"/></td>
		</c:if>
		<td><input type="button" value="退出" onclick="location='ExitServlet'"/></td>
	</tr>
	</table>
</form>
<h3>简单查询</h3>
<form action="FindBookServlet" method="post">
<table>
	<tr>
		<td>
		<select name="findType">
			<option value="bkName">书名</option>
			<option value="bkAuthor">作者</option>
		</select>
		<input type="text" name="findInfo"/>
		</td>	
		<td><input type="submit" value="搜索"/></td>	
	</tr>
	</table>
	</form>
<h3>高级查询</h3>
<form action="FindBookServlet" method="post">
	<table>
		<tr>
			<td>图书名称</td>
			<td><input type="text" name="bkName"/></td>
			<td>图书作者</td>
			<td><input type="text" name="bkAuthor"/></td>
			<td>出版社名</td>
			<td><input type="text" name="bkPress"/></td>
		</tr>
		<tr>
			<td>分类号</td>
			<td><input type="text" name="bkCatalog"/></td>
			<td>出版日期</td>
			<td><input type="text" name="bkDatePress" ></td>
 			<td><input type="submit" value="搜索"/></td>
		</tr>
	</table>
</form>

<table>
	<tr>
		<td>ID</td>
		<td>索书号</td>
		<td>书名</td>
		<td>作者</td>
		<td>出版社</td>
		<td>出版日期</td>
		<td>ISBN</td>
		<td>分类号</td>
		<td>语种</td>
		<td>页数</td>
		<td>价格</td>
		<td>入馆时间</td>
		<td>状态</td>
	</tr>

<c:forEach items="${findBookList}" var="items">
	<tr>
		<td>${items.getBkId()}</td>
		<td>${items.getBkCode()}</td>
		<td>${items.getBkName() }</td>
		<td>${items.getBkAuthor() }</td>
		<td>${items.getBkPress() }</td>		
		<td>${items. getBkDatePress() }</td>
		<td>${items.getBkISBN() }</td>
		<td>${items.getBkCatalog() }</td>
		<td>${items.getBkLanguage()}</td>
		<td>${items.getBkPages() }</td>
		<td>${items.getBkPrice()  }</td>
		<td>${items.getBkDateIn() }</td>
		<td>${items.getBkStatus() }</td>
		
		<c:if test="${adminType!=4 }">
		<td><a href="ShowUpdateBookServlet?bkCode=${items.getBkCode()}"><input type="button" value="维护书籍"/></a></td>
		</c:if>
	</tr>
</c:forEach>
</table>	

</body>
</html>