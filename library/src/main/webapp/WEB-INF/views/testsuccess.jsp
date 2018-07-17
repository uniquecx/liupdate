<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>用户信息</title> 
<%@ include file="include.jsp" %>
<script>
	$(function(){
		 $('#newsmsg').datagrid({
			url:'<%=basePath%>test/getuser',
		    idField: "id",//一般对应主键唯一标示行记录的属性
		    sortName : 'id',//排序的属性
			sortOrder : 'asc',
		    rownumbers: true,//是否显示行序号
		    method:'get',
		    toolbar: '#tb',  //datagrid上方的查询面板
		   // fit: true,//是否自适应界面宽高
		    singleSelect:true,//是否能多行选择
		    pagination:true,//是否分页操作
	        pageSize: 3,         //分页大小  
	        pageNumber:1,         //第几页显示（默认第一页，可以省略）  
	        //pageList: [10, 20, 30], //设置每页记录条数的列表  
	        checkOnSelect: true, selectOnCheck: false,
			 
		 });		
	})
	
	 function searchnews(){
		alert($("#searchname").val())
		$("#newsmsg").datagrid('load',{
			username:$("#searchname").val(),
			
		})
	} 
	function openAddWindow(){
		$("#add_window").window("open");
	}
	
	//添加
	 function addNews(){
		
		$.ajax({
			url:"<%=basePath%>test/add",
			type:"post",
			dataType:"json",
			data:{
				username:$("#addusername").val(),
				password:$("#addpassword").val(),
				gender:$("#addgender").combobox('getValue'),
				date:$("#adddate").datebox("getValue")
					},
		success:function(res){
			if(res>0){
				$('#newsmsg').datagrid();
			}else{
				Msg("添加失败")
			}
		},
		error:function(){
			Msg("出问题了")
			
		}
		})
		
	}
	
	//提示框
		function Msg(msg){
			$.messager.show({
				title:'消息',
				msg:msg,
				showType:'show'
			});
		}
	
	
	
		//删除
			function deleteNews(){
			var ids=[];
				var rows=$("#newsmsg").datagrid("getChecked");
				
				
				if(rows!=""){
					$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
						if (!r) { 
						return; 
						} 
					
					for(var i=0;i<rows.length;i++){
						ids.push(rows[i].id);
			}
					;
				$.ajax({
					url:"<%=basePath%>news/deleteNews",
					type:"post",
					dateType:"json",
					data:{ids:JSON.stringify(ids)} ,//格式化数组
					success:function(res){
						if(res>0){
							Msg("删除成功");
							
							$('#newsmsg').datagrid("reload")//重新加载 ;
							
						}else{
							Msg("删除失败")
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
		
		 //修改数据，修改一行
		function openUpdateWindow(){
			var rows=$("#newsmsg").datagrid("getChecked");
			if(rows!=""){
				if(rows.length==1){
				$("#update_window").window("open");
				  var row=rows[0];
				  
				  $("#updateNews").form("clear");
				  $('#updateNews').form('load',row);
				  
				}else{
					Msg("请不要选择多行")
				}
			}else{
				Msg("请选择一行修改")
			}
			
		}
		 function updateNews(){
			 
			 $.ajax({
				 url:"<%=basePath%>news/updateNews",
			     type:"post",
			     dataType:"json",
			     data:{
			    	 newmain:$("#main").val(),
						newid:$("#id").val(),
						imageurl:$("#imageurl").val(),
						url:$("#url").val()
			     },
			     success:function(res){
			    	 if(res>0){
			    		 Msg("修改成功");
			    		 $('#newsmsg').datagrid();
			    	 }else{
			    		 Msg("修改失败");
			    	 }
			     },
			     error:function(){
			    	 Msg("出问题");
			     }
			 })
			 
		 }
		
	</script>
</head>
<body>
 
	
	<div style="margin:20px 0;"></div>
	<table id="newsmsg" style="width:600px;height:400px;margin:auto">
		
		<thead>
			<tr>
			    <!-- <th data-options="field:'ck',checkbox:true"></th> -->
				<th data-options="field:'id',width:100">ID</th>
			    <th data-options="field:'username',width:100">用户名</th>
			    <th data-options="field:'password',width:100">密码</th>
			    <th data-options="field:'gender',width:100">性别</th>
			    <th data-options="field:'date1',width:100">创建日期</th>
			    
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
		  <a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteNews()"></a>
		  </div>
		
		<div>
		    用户名:<input class="easyui-validatebox" style="width:240px" name="searchname" id="searchname" value="">
		    
			<a onclick="searchnews()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	
	<!-- add事件 -->
	   <div  id="add_window" title="添加" class="easyui-window" style="width:400px;height:400px;"   data-options="modal:true"  closed="true" >
	  <form id="addNews">
         <table>
          
         <tr>
          <td><lable>用户名：</lable></td>
          <td><input type="text" name="addusername" id="addusername" class="easyui-validatebox" required>
          </td>
         </tr> 
         <tr>
          <td><lable>密码：</lable></td>
          <td><input type="text" name="addpassword" id="addpassword" class="easyui-validatebox" required>
          </td>
         </tr> 
               <tr><td><lable>性别：</lable></td>
                  <td><select class="easyui-combobox" name="addgender" id="addgender" style="width:100px;">
		<option value="男" >男</option>
		<option value="女">女</option>
	</select>
                  </td>
			</tr>
			</tr> 
               <tr><td><lable>日期: </lable></td>
                  <td><input class="easyui-datebox" style="width:150px" id="adddate" name="adddate"></td>
			</tr>
			
			</table>
			    
         <button id="addbutton" onclick="addNews()">添加用户</button>
	    </form>
	    </div>
	    
	    
	    <!-- 修改1条数据 -->
	    <div  id="update_window" title="修改资讯信息" class="easyui-window" style="width:400px;height:400px;"   data-options="modal:true"  closed="true" >
	  <form id="updateNews">
         <table>
         <input type="hidden" name="id" id="id">
          <tr>
          <td><lable>资讯id：</lable></td>
          <td><input type="text" name="id" id="id" class="easyui-validatebox" disabled="disabled" >
          </td>
         </tr> 
         <tr>
          <td><lable>资讯主题：</lable></td>
          <td><input type="text" name="main" id="main" class="easyui-validatebox" required>
          </td>
         </tr> 
         <tr>
          <td><lable>图片链接：</lable></td>
          <td><input type="text" name="imageurl" id="imageurl" class="easyui-validatebox" required>
          </td>
         </tr> 
               <tr><td><lable>信息链接：</lable></td>
                  <td><input type="text" name="url" id="url" class="easyui-validatebox" >
                  </td>
			</tr>
                  </table>
         <button id="updatebutton" onclick="updateNews()">修改资讯信息</button>
	    </form>
	    </div>
	    
</body>
