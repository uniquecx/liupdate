<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
<script>
function updatepwd(){
	 var password=$("#password").val();
	 var npassword=$("#npassword").val();
	 var rpassword=$("#rpassword").val();
	 if(npassword==rpassword){
		if(password==<%=session.getAttribute("password")%>){
			alert(1)
			$("#updatepwdform").submit();
		}else{
			 alert("旧密码输入错误")
			 $("#updatepwdform").form("clear");
			 $("#username").val(<%=session.getAttribute("username")%>);
		}
	 }else{
		 alert("2次密码输入不一致")
		 $("#updatepwdform").form("clear");
		 $("#username").val(<%=session.getAttribute("username")%>);
	 }
}
</script>
</head>
<body>
<center>
<form id="updatepwdform" action="<%=basePath %>login/updatePwd" method="post">
  <h4>修改密码</h4>
  &nbsp&nbsp&nbsp旧密码 :
			<input class="easyui-textbox" style="width:20%;height:22px" id="password" type="password" name="password" required>
		<br>
		<br>
   &nbsp&nbsp&nbsp新密码:
			<input class="easyui-textbox" style="width:20%;height:22px" id="npassword" type="password" name="npassword" required>
		<br>
		<br>
    确认密码:
			<input class="easyui-textbox" style="width:20%;height:22px"id="rpassword" type="password" name="rpassword" required>
		<br>
		<br>
		<input type="button" value="提交" onclick="updatepwd()">
    </form>
</center>
</body>
</html>