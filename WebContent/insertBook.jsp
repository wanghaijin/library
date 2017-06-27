
<%@ page language="java" import="java.util.*,com.library.model.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新书入库</title>
<style type="text/css">
    #result {width:240px;height:300px;border:1px solid #000;}
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
<h4 align="center">新书入库</h4>
<form  action="InsertBookServlet" method="post">
<c:if test="${insertError!=null }">
	<h3><c:out value="${insertError }"></c:out></h3>
	<c:remove var="insertError" scope="session"/>
</c:if>
	<table width="1000px" align="left">
		<tr>
			<td width="300px" style="float:left;margin: 0px;padding: 0px;">
				<table>
					<tr>
						<td>图书起始序号</td>
						<td><input type="text" value="${bookSize }" readonly="readonly"/></td>
					</tr>
					<tr>
 						<td > 图 书名 称</td>
 						<td><input type="text" name="bkName"/></td>
 						</tr>
 						<tr>
   						<td>索 书 号</td>
   						<td><input type="text"  name="bkCode"/></td>
   						</tr>
   						<tr>
   						<td>作者</td>
   						<td><input type="text" name="bkAuthor"/></td>
   						<tr>
   						<td>出版 社</td>
   						<td><input type="text"  name="bkPress"/></td>
   						</tr>
   						<tr>
 						<td>出 版日期 </td>
 						 <td><input type="text" name="bkDatePress" value="1900-01-01"  style="color:#CDC9C9;"onfocus="if (value =='1900-01-01'){this.style.color='#000';value =''}"
 						 onblur="if (value ==''){this.style.color='#CDC9C9';value='1900-01-01'}" /></td>
 						 </tr>
 						 <tr>
  						<td>ISBN</td>
  						<td><input type="text"  name="bkISBN"/></td>
  						</tr>

   						<tr>
   						<td>分类号</td>
   						<td><input type="text" name="bkCatalog"/></td>
   						</tr>
   						<tr>
   						<td>语种  </td>
   						<td>
   						<select name="bkLanguage">
								<option value="0">中文</option>
								<option value="1">英文</option>
								<option value="2">日文</option>
								<option value="3">俄文</option>
								<option value="4">德文</option>
								<option value="5">法文</option>
						</select>
						</td>
   						</tr>
   						<tr>
   						<td>图 书页面</td>
   						<td><input type="text" name="bkPages" /></td>
   						</tr>
   						<tr>
   						<td>图书 价格 </td>
   						<td><input type="text" name="bkPrice"/></td>
   						</tr>
   						<tr>
   						<td>图 书本书：</td>
   						<td><input type="text" name="bkCount"/></td>
					</tr>
				</table>
			</td>
			<td width="300px" style="float:left;margin: 0px;padding: 0px;">
			
				<label>图书简介</label>
				<textarea rows="20" cols="30"  name="bkBrief"></textarea><br />
			
			</td>
			<td width="300px" style="float:right;margin: 0px;padding: 0px;">
				<div id="main">
   					<div class="demo">
        				<label>请选择一个图像文件：</label>      		
        				<input type="file" id="file_input"  name="bkCover" />
        				<br />
    					<div id="result">
          				<!-- 这里用来显示读取结果 -->
    					</div> 
   					</div>
				</div>
				<input type="submit" value="提交" />

			</td>
			
		</tr>
	
	</table>
</form>


		
		






<script type="text/javascript">
var result = document.getElementById("result");
var input = document.getElementById("file_input");
if(typeof FileReader === 'undefined'){
	result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
	input.setAttribute('disabled','disabled');
}else{
	input.addEventListener('change',readFile,false);
}
			
function readFile(){
	var file = this.files[0];
	if(!/image\/\w+/.test(file.type)){
		alert("请确保文件为图像类型");
		return false;
	}
	var reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload = function(e){
		result.innerHTML = '<img src="'+this.result+'" alt="" width="240px" height="300px"/>'
	}
}
</script>
</body>

</html>

