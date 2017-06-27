<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息更改</title>
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
<h4 align="left">信息更改</h4>
<form  action="UpdateReaderServlet" method="post">
	<table width="700px" align="left">
	
		<tr>
			<td width="300px" style="float:left;margin: 0px;padding: 0px;">
				<table>
					<tr>
 						<td >读者编号</td>
 						<td><input type="text" name="rdId" value="${updateReader.getRdId() }" readonly="readonly"/></td>
 						</tr>
 						<tr>
   						<td>姓名</td>
   						<td><input type="text"  name="rdName" value="${updateReader.getRdName() }"/></td>
   						</tr>
   						<tr>
   						<td>性别</td>
   						<td><select name="rdSex" id="rdSex">
								<option value="男">男</option>
								<option value="女">女</option>
						</select></td>
   						<tr>
   						<td>类别</td>
   						<td><select name="rdType" id="rdType">
								<c:forEach items="${adminTypeList }" var="items">
								<option value="${items.getRdType() }">${items.getRdTypeName()}</option>
								</c:forEach>
						</select></td>
   						</tr>
   						<tr>
   						<td>证件状态</td>
   						<td>
   						<select name="rdStatus" id="rdStatus">
   							<option value="注销">注销</option>
   							<option value="挂失">挂失</option>
   							<option value="有效">有效</option>
   						</select>
   						</td>
   						</tr>
   						<tr>
 						<td>单位名称</td>
 						  <td><select name="rdDept" id="rdDept">
					<option value="计算计学院" selected="selected">计算计学院</option>
					<option value="管理学院">管理学院</option>
					<option value="经济学院">经济学院</option>
					</select>
 						</td>
 						 </tr>
 						 <tr>
  						<td>电话号码</td>
  						<td><input type="text"  name="rdPhone" value="${updateReader.getRdPhone() }"/></td>
  						</tr>

   						<tr>
   						<td>电子邮箱</td>
   						<td><input type="text" name="rdEmail" value="${updateReader.getRdEmail() }"/></td>
   						</tr>
   						<tr>
				</table>
			</td>
			<td width="300px" style="float:right;margin: 0px;padding: 0px;">
				<div id="main">
   					<div class="demo">
        				<label>读者照片</label> <br/>     		
        				<input type="file" id="file_input"  name="rdPhoto" value="${updateReader.getRdPhoto() }" />
        				<br />
    					<div id="result">
          				<!-- 这里用来显示读取结果 -->
          				<img src="${updateReader.getRdPhoto() }" alt="" width="100px" height="150px"/>
    					</div> 
   					</div>
				</div>
				<input type="submit" value="更改信息" />
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
		result.innerHTML = '<img src="'+this.result+'" alt="" width="100px" height="150px"/>'
	}
}

for(var i=0;i<document.getElementById('rdType').options.length;i++){ 
if(document.getElementById('rdType').options[i].value=='${updateReader.getRdType()}'){ 
document.getElementById('rdType').options[i].selected=true; 
} 
} 
for(var i=0;i<document.getElementById('rdSex').options.length;i++){ 
if(document.getElementById('rdSex').options[i].value=='${updateReader.getRdSex()}'){ 
document.getElementById('rdSex').options[i].selected=true; 
} 
} 
for(var i=0;i<document.getElementById('rdStatus').options.length;i++){ 
if(document.getElementById('rdStatus').options[i].value=='${updateReader.getRdStatus()}'){ 
document.getElementById('rdStatus').options[i].selected=true; 
} 
} 
for(var i=0;i<document.getElementById('rdDept').options.length;i++){ 
if(document.getElementById('rdDept').options[i].value=='${updateReader.getRdDept() }'){ 
document.getElementById('rdDept').options[i].selected=true; 
} 
} 
</script>
</body>
</html>