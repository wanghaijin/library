<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限更改</title>
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
	<form action="FindAdminRolesServlet" method="post">
		<table>
			<tr>
				<td>编号</td>
				<td><input type="text" name="rdId" value="${adminRdId }"/></td>
				<td><input type="submit" value="搜索" /></td>
			</tr>
		</table>
		</form>
	<form action="UpdateAdminRolesServlet" method="post">
		<table>
		<tr>
		<td>管理员类型</td>
			<td><select name="rdAdminRoles" id="rdAdminRoles">
				<option value="0">系统管理</option>
				<option value="1">读者管理</option>
				<option value="2">图书管理</option>
				<option value="3">借书管理</option>
				<option value="4">读者</option>
			</select>
			</td>
		<c:if test="${AdminRoles!=null }">
			<td><input type="submit" value="更改管理员类型"/></td>
		</c:if>
			</tr>
			</table>
	</form>
	
	<script type="text/javascript">
		for(var i=0;i<document.getElementById('rdAdminRoles').options.length;i++){ 
			if(document.getElementById('rdAdminRoles').options[i].value=='${AdminRoles}'){ 
			document.getElementById('rdAdminRoles').options[i].selected=true; 
	} 
} 
	</script>
</body>
</html>