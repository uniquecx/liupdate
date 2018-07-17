<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>主页</title>  
<%@ include file="include.jsp" %>
<script>
 function openupdatepwd(){
	 $("#updatepwd").window("open");
 }
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
 
 $(function(){
	 //加载树形结构菜单
	 $("#menuTree").tree({
		 url:"<%=basePath %>login/loadMenuTree",
		 method:"post",
		 animate:true,
		 onSelect:function(node){ //树形菜单被选中触发
			 //alert(node.url);
		 if(node.url!=""&&node.url!=null&&node.url!="javascript:void(0)"){
			 alert(node.url)
			 $("#mainIframe").attr("src",$("#path").val()+node.url);
		 }
			
		 }
	 });

  });
</script>
</head>
<body class="easyui-layout" style="overflow:-Scroll;overflow-y:hidden">
<div region="north" style="height:80px;">
    <!-- 页面头部 -->
    <h1>基于java的图书借阅管理系统</h1>
    欢迎<%=session.getAttribute("name") %>登陆<br>

  <input type="button" onclick="openupdatepwd()" value="修改密码">
</div>
<input type="hidden" value="<%=basePath %>" id="path">
<div region="west" split="false" style="width:15%" title="导航菜单">
 <ul id="menuTree" class="easyui-tree" ></ul>
    
</div>

<div region="center"  style="width:85%">
     <iframe id="mainIframe" style="width:100%;height:100%;" src="<%=basePath%>"></iframe>
</div>



<div region="south">
    页面底部 
</div>

//修改密码window
 <div  id="updatepwd" title="修改密码" class="easyui-window" style="width:300px;height:300px;"   data-options="modal:true"  closed="true" >
  <form id="updatepwdform" action="<%=basePath%>user/updatePwd" method="post">
  <table>
     <tr>
          <td><lable>用户名：</lable></td>
          <td><input class="easyui-validatebox" name="username" id="username" value=<%=session.getAttribute("username") %> readonly="readonly" ></input><td>
         </tr> 
          <tr>
          <td><lable>旧密码：</lable></td>
          <td><input class="easyui-validatebox" name="password" id="password" type="password" required></input><td>
         </tr> 
          <tr>
          <td><lable>新密码：</lable></td>
          <td><input class="easyui-validatebox" name="npassword" id="npassword" type="password" required></input><td>
         </tr> 
          <tr>
          <td><lable>再新密码：</lable></td>
          <td><input class="easyui-validatebox" name="rpassword" id="rpassword" type="password" required></input><td>
         </tr> 
         <tr>
          <input type="button" value="提交" onclick="updatepwd()">
         </tr>
  </table>
  </form>
 </div>
</body>
</html>