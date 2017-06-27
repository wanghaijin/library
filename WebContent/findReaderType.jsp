
<%@ page language="java" import="java.util.*,com.library.model.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>类型管理</title>
<style type="text/css">
    input{
width:80px
}
td{
width=30px
}
</style>
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
		
				<table width="300px">
					<tr>
						<td><input value="读者编号"  readonly="readonly"/></td>
						<td><input value="读者类别"  readonly="readonly"/></td>
						<td><input value="可借书数量"  readonly="readonly"/></td>
						<td><input value="可借书天数"  readonly="readonly"/></td>
						<td><input value="可续借次数"  readonly="readonly"/></td>
						<td><input value="罚款率（元/天）"  readonly="readonly"/></td>
						<td><input value="证书有效期"  readonly="readonly"/></td>
						<td><input value="是否更改"  readonly="readonly"/></td>
					</tr>
	</table>
	<c:forEach items="${typeList}" var="items">
	<form action="UpdateReaderTypeServlet" method="post">
	<table>
					<tr>
						<td><input type="text" name="rdType" value="${items.getRdType() }" readonly="readonly" /></td>
						<td ><input type="text" name="typeListName${items.getRdType()  }"  value="${items.getRdTypeName() }" readonly="readonly"/></td>
						<td><input type="text"name="typeListQty${items.getRdType() }"  value="${items.getCanLendQty() }"/></td>
						<td><input type="text"name="typeListDay${items.getRdType() }"  value="${items.getCanLendDay()}"/></td>
						<td><input type="text" name="typeListTimes${items.getRdType()  }" value="${items.getCanContinueTimes()  }"/></td>
						<td><input type="text" name="typeListRate${items.getRdType()  }" value="${items.getPunishRate() }"/></td>
						<td><input type="text" name="typeListDate${items.getRdType()  }" value="${items.getDateValid()  }"/></td>
						<td><input type="submit" value="更新"/></td>
					</tr>	
</table>
</form>
	</c:forEach>
<c:if test="${updateType!=null }">
	<c:out value="${updateType }"></c:out>
</c:if>

		</div>
</body>
</html>