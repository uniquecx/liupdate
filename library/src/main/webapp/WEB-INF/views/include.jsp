<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
     <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String imgPath=request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+"/"+"upload/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/easyUI/themes/icon.css">
   
	<script type="text/javascript" src="<%=basePath %>js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/easyUI/locale/easyui-lang-zh_CN.js"></script>
	<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>css/bootstrap-fileinput.css" rel="stylesheet">
	
<script src="<%=basePath %>js/easyUI/bootstrap-fileinput.js"></script>
