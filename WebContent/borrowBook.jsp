<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>借阅管理</title>
<style type="text/css">
    #result {width:300px;height:150px;border:1px solid #000;}
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
<div>
<form action="BorrowFindReaderServlet" method="post">
	<h3>读者信息</h3>
		<table>
			<tr>
				<td>读者编号
				<input type="text" name="rdId" value="${reader.getRdId()}"/>
				</td>
				<td><input type="submit" value="查找"/></td>
			</tr>
			<tr>
				<td>读者姓名<input type="text"  readonly="readonly"     value="${reader.getRdName() }"/></td>
				<td>读者单位<input type="text"	 readonly="readonly"  value="${reader.getRdDept() }"/></td>
				<td>读者类型<input type="text"   readonly="readonly"  value="${type.getRdTypeName()}"/></td>
			</tr>
			<tr>
				<td>可借书数量<input type="text" readonly="readonly"  value="${type.getCanLendQty()}"/></td>
				<td>可借天数<input type="text"   readonly="readonly"  value="${type.getCanLendDay()}"/></td>
				<td>已借数量<input type="text"   readonly="readonly"  value="${borrowList.size()}"/></td>
			</tr>
		</table>
		<c:if test="${nextBorrowError!=null }">
			<c:out value="${nextBorrowError }"></c:out>
			<c:remove var="nextBorrowError" scope="session"/>
		</c:if>
		</form>
		<h3>已借图书</h3>
			<table border="1">
				<tr>
					<td>图书序号</td>
					<td>图书名称</td>
					<td>图书作者</td>
					<td>续借次数</td>
					<td>借阅日期</td>
					<td>应还日期</td>
					 <td>超期天数</td>
					<td>超期金额/元</td>
				</tr>
				<c:forEach items="${borrowList}" var="items" varStatus="loop">
					<tr>
						<td><input type="text" style="width:60px;"value="${items.getBkID() }"/></td>
						 <td><input type="text" style="width:60px;"value="${ReturnBookList[loop.count-1].getBkName()}"/></td>
						 <td><input type="text" style="width:60px;"value="${ReturnBookList[loop.count-1].getBkAuthor()}"/></td>
						<td><input type="text" style="width:60px;"value="${items.getIdContinueTimes() }"/></td>
						<td><input type="text"style="width:80px;" value="${items.getIdDateOut()}"/></td>
						<td><input type="text" style="width:80px;"value="${items.getIdDateRetPlan() }"/></td>
						<td><input type="text" style="width:60px;"value="${items.getIdOverDay() }"/></td>
						<td><input type="text" style="width:60px;"value="${items.getIdOverMoney() }"/></td>
						<td><a href="ReturnBookServlet?bkId=${items.getBkID()}"><input type="button" value="还书"/></a></td>
						<td><a href="NextBorrowBookServlet?bkId=${items.getBkID()}"><input type="button" value="续借"/></a></td>
					</tr>				
				</c:forEach>
			</table>
</div>
<div>
	<form action="BorrowFindBookServlet" method="post">
	<h3>图书信息</h3>
		<table>
			<tr>
				<td>图书编号<input type="text" name="bkId" value="${BorrowBkId}"/></td>
				<td><input type="submit" value="搜索"/></td>
			</tr>
			<tr>
			
				<td>图书名称<input type="text"   name="bkName" value="${BorrowBkName }"/></td>
				<td><input type="submit" value="搜索"/></td>
			</tr>
			<c:if test="${findBorrowError!=null }">
			<tr><td><c:out value="${findBorrowError }"></c:out>      </td></tr>
			<c:remove var="findBorrowError" scope="session"/>
			</c:if>
				<c:if test="${borrowError!=null }">
			<tr><td><c:out value="${borrowError }"></c:out>      </td></tr>
			<c:remove var="borrowError" scope="session"/>
			</c:if>
		</table>	
	</form>
	<table border="1" >
		<tr>
			<td>序号</td>
			<td>编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>出版日期</td>
			<td>ISBN</td>
			<td>分类号</td>
			<td>页数</td>
			<td>价格</td>
			<td>入馆日期</td>
			<td>借书</td>
		</tr>
		<c:forEach items="${BorrowBookList}" var="items">
		<tr>
			<td><input type="text" style="width:60px;" value="${items.getBkId()}" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkCode() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkName() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkAuthor() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkPress() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkDatePress() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkISBN() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkCatalog() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkPages() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkPrice() }" readonly="readonly"/></td>
			<td><input type="text" style="width:60px;"value="${items.getBkDateIn() }" readonly="readonly"/></td>
			<td><a href="BorrowBookServlet?bkId=${items.getBkId()}" ><input  type="button" value="借书"/></a></td>
		</tr>
		</c:forEach>
		<c:remove var="BorrowBookList" scope="session"/>
	</table>
</div>

</body>
</html>