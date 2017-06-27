
<%@ page language="java" import="java.util.*,com.library.model.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>读者查找</title>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
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
<h4 align="center">读者查找</h4>
		<div class="main" align="center">
			<form action="FindReaderServlet" method="post">
				<table>
					<tr>
						<td>读者类别：<select name="rdType">
								<c:forEach items="${adminTypeList }" var="items">
								<option value="${items.getRdType() }">${items.getRdTypeName()}</option>
								</c:forEach>
						</select>
						</td>
						<td>单位：<select name="rdDept">
								<option>计算机学院</option>
								<option>管理学院</option>
								<option>经济学院</option>
						</select>
						</td>
						<td>姓名：<input type="text" name="rdName"></td>
						<td><input type="submit" value="查询"></td>
						<!-- <td> <input type="submit" value="EXCL"></td>-->
					</tr>
				</table>
				</form>
				<table width="700px" border="1px">
					<tr>
						<td>ID</td>
						<td>姓名</td>
						<td>性别</td>
						<td>类别</td>
						<td>院系</td>
						<td>电话</td>
						<td>e-mail</td>
						<td>状态</td>
						<td>已借书</td>
						<td>注册日期</td>
					</tr>
				
					<c:forEach items="${readerList}" var="items">
						<tr>
						<td>${items.getRdId()}</td>
						<td>${items.getRdName()}</td>
						<td>${items.getRdSex() }</td>
						<td>${items.getRdType() }</td>
						<td>${items.getRdDept() }</td>
						<td>${items.getRdPhone()}</td>
						<td>${items.getRdEmail() }</td>
						<td>${items.getRdStatus()}</td>
						<td>${items.getRdBorrowQty()}</td>
						<td>${items.getRdDateReg()}</td>
						<td><a href="ShowUpdateReaderServlet?rdId=${items.getRdId()}"><input type="button" value="更新数据"/></a></td>
					</tr>
					</c:forEach>
					</table>			
		</div>
</body>
</html>