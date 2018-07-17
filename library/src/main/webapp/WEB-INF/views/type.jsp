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
			url:'<%=basePath%>type/getType',
		    idField: "typenumber",//一般对应主键唯一标示行记录的属性
		    sortName : 'typenumber',//排序的属性
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
	function openAddWindow(){
	$("#add_window").window("open");
}
	function addType(){
		$.ajax({
			url:"<%=basePath%>type/addType",
			type:"post",
			dataType:"JSON",
			data:{
				booktype:$("#addbooktype").val(),
			},
			success:function (res){
				
			}
		})
	}
	function openUpdateWindow(){
		var rows=$("#dg").datagrid("getChecked");
		if(rows!=""){
			if(rows.length==1){
			$("#update_window").window("open");
			  var row=rows[0];
			  alert(row)
			  $("#updateType").form("clear");
			  $('#updateType').form('load',row);
			  
			}else{
				Msg("请不要选择多行")
			}
		}else{
			Msg("请选择一行修改")
		}
	}
	//提示框
	function Msg(msg){
		$.messager.show({
			title:'消息',
			msg:msg,
			showType:'show'
		});
	}

	function updateType(){
		var rows=$("#dg").datagrid("getChecked");
		if(rows!=""){
			if(rows.length==1){
			$("#update_window").window("open");
			  var row=rows[0];
			  alert(row)
			  $("#updateType").form("clear");
			  $('#updateType').form('load',row);
			  
			}else{
				Msg("请不要选择多行")
			}
		}else{
			Msg("请选择一行修改")
		}
		
			$.ajax({
				url:"<%=basePath%>type/updateType",
				type:"post",
				dataType:"JSON",
				data:{
					typenumber:$("#typenumber").val(),
					booktype:$("#booktype").val()
				},
				success:function(res){
					if(res>0){
						Msg("修改成功")
					}else{
						Msg("修改失败")
					}
				},
					error:function(){
						Msg("修改失败")
					
			}
			})
		
	
	}
	function deleteType(){
	
		var rows=$("#dg").datagrid("getChecked");
		
		if(rows.length=="1"){
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) { 
				return; 
				} 
			
			var typenumber=rows[0].typenumber;

			
		$.ajax({
			url:"<%=basePath%>type/deleteType",
			type:"post",
			dateType:"json",
			data:{typenumber:typenumber} ,//格式化数组
			success:function(res){
				if(res>0){
					Msg("删除成功");
					
					$('#dg').datagrid("reload")//重新加载 ;
					
				}else{
					Msg("请先删除此类有关读书")

				}
				
			} ,
			error:function(){
				Msg("出问题了")
			}
		})
	
			})

}else{
Msg("请选中一行")
}
	}
	</Script>
	
</head>
<body>
 <div style="margin:20px 0;"></div>
	<table id="dg" style="width:1000px;height:400px">
		
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'typenumber',width:80">类别编号</th>
				<th data-options="field:'booktype',width:80">类别名称</th>
			</tr>
		</thead>
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
		  <a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteType()"></a>
		  </div>
	</table>
	<!-- add事件 -->
	    <div  id="add_window" title="添加类别信息" class="easyui-window" style="width:250px;height:200px;"   data-options="modal:true"  closed="true" >
	  <form id="addType">
         <table>
          <tr>
          <td><lable>类别名称：</lable></td>
          <td><input type="text" name="addbooktype" id="addbooktype" class="easyui-validatebox" required><td>
         </tr> 
                 
         </table>
     
         <button id="addbutton" onclick="addType()">添加类别</button>
	    </form>
	    </div>
	<!-- update事件 -->
	  <div  id="update_window" title="修改类别信息" class="easyui-window" style="width:250px;height:200px;"   data-options="modal:true"  closed="true" >
	  <form id="updateType">
	  <input type="hidden" name="typenumber" id="typenumber"> 
         <table>
          <tr>
          <td><lable>类别名称：</lable></td>
          <td><input type="text" name="booktype" id="booktype" class="easyui-validatebox" required><td>
         </tr> 
                 
         </table>
     
         <button id="updatebutton" onclick="updateType()">修改类别</button>
	    </form>
	    </div>
	
	
</body>
</html>