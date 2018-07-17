<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
<Script>
$(function(){
		 $('#dg').datagrid({
			url:'<%=basePath%>readertype/getType',
		    idField: "rid",//一般对应主键唯一标示行记录的属性
		    sortName : 'rid',//排序的属性
			sortOrder : 'asc',
		    rownumbers: true,//是否显示行序号
		    method:'get',
		    toolbar: '#tb',  //datagrid上方的查询面板
		   // fit: true,//是否自适应界面宽高
		    singleSelect:true,//是否能多行选择
		    pagination:true,//是否分页操作
	        pageSize: 10,         //分页大小  
	        pageNumber:1,         //第几页显示（默认第一页，可以省略）  
	        pageList: [10, 20, 30], //设置每页记录条数的列表  
	        checkOnSelect: true, selectOnCheck: false,
			 
		 });		
	})
	
	</Script>
</head>
<body>
<div style="margin:20px 0;"></div>
	<table id="dg" style="width:1000px;height:400px">
		
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'rid',width:80">类别编号</th>
				<th data-options="field:'type',width:80">读者类别</th>
				<th data-options="field:'number',width:80">可借本数</th>
				<th data-options="field:'datenumber',width:80">可借天数</th>
				<th data-options="field:'count',width:80">续借次数</th>
			</tr>
		</thead>
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
		  <a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBook()"></a>
		  </div>
	</table>
	

</body>
</html>