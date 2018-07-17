<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
<style type="text/css">
body{margin:0px;padding:0px}
ul{list-style:none;}
ul li{width:200px;height:33px;display:block}
</style>
<script>
function changeImage(){
	   $("#CodeImage").attr("src","<%=basePath %>user/getcode?date="+new Date().getTime());
}
function openLoginWindow(){
	$("#login_window").window("open");
}
</script>
</head>
<body>
<div  style="height:100px;border:1px red solid">
    
    <center><h1>基于java的图书借阅管理系统</h1></center>
      <a id="login" onclick="openLoginWindow()">登陆</a>
</div>
<div>
<h4>推荐图书</h4>
 <table style="width:900px;height:200px;border:1px red solid">
<tr>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>编号</li>
			<li>书名</li>
			<li>类别</li>
			<li>作者</li>
			<li>描述</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
</tr>
<tr>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>编号</li>
			<li>书名</li>
			<li>类别</li>
			<li>作者</li>
			<li>描述</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
</tr>
<tr>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>编号</li>
			<li>书名</li>
			<li>类别</li>
			<li>作者</li>
			<li>描述</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
	<td>
		<img src="C:\Users\陈涛\Desktop\1.jpg" style="width:150px;height:200px">
	</td>
	<td>
		<ul>
			<li>111</li>
			<li>222</li>
			<li>333</li>
			<li>444</li>
			<li>555</li>
		</ul>
	</td>
</tr>
</table>
</div>
<div  id="login_window" title="登陆" class="easyui-window" style="width:500px;height:500px;"   data-options="modal:true"  closed="true" >
		<div style="padding:3px 2px;border-bottom:1px solid #ccc">登陆</div>
		<form id="ff" method="post" action="<%=basePath %>login/login">
			<div>
				<label for="username">姓名:</label>
				<input class="easyui-validatebox" type="text" name="username" required="true"></input>
			</div>
			<br>
			<div>
				<label for="password">密码:</label>
				<input class="easyui-validatebox" type="password" name="password" required="true"></input>
			</div>
			<br>
			
			<div>
				<label for="code">验证码:</label>
				<input type="text" class="easyui-validatebox" name="code" maxlength="4">
			</div>
			<br>
			<div>
                    <span class="code_img"> <img  
                        src="<%=basePath %>login/getcode"  
                        width="110" height="40" id="CodeImage"/>  
                    </span> <span> 
                   <a href="javascript:changeImage();">换一张</a> 
                    </span>  
			</div>
			<br>
			<div>
				<input type="submit" value="登陆">
			</div>
		</form>
	</div>
</body>
</html>