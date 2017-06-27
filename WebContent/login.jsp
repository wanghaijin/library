<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>登录页面</title>
</head>
<body>
	<form action="LoginServlet" method="post" >
		<table align="center">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="Submit" value="登录" />
				</td>
			</tr>
			<tr>
				<c:if test="${adminType!=null }">
					<c:out value="${adminType }"></c:out>
					<c:remove  var="adminType"  scope="session"  />
				</c:if>
			</tr>
		</table>
	</form>
</body>
</html>