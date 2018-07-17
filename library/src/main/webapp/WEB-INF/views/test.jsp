<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>用户登录</title>  
<%@ include file="include.jsp" %>

<script type="text/javascript">
function changeImage(){
	   $("#CodeImage").attr("src","<%=basePath %>user/getcode?date="+new Date().getTime());
} 


 </script>
 
</head>  
<body> 
<div  style="height:100px;border:1px red solid">
    
    <center><h1>登陆测试</h1></center>
     
</div>
<center>
<div style="width:600px;background:#fafafa;padding:20px;">
		<div style="padding:3px 2px;border-bottom:1px solid #ccc">管理员登陆</div>
		<form id="ff" method="post" action="<%=basePath %>test/login">
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
				<input type="submit" value="登陆">
			</div>
		</form>
	</div>
</center>
</body>  
</html>  


   

