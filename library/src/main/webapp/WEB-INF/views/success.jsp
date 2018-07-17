<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
	<meta charset="UTF-8">
	<title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
	<%@ include file="include.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			 $('#dg').datagrid({
				url:'<%=basePath%>book/getBook',
			    idField: "bno",//一般对应主键唯一标示行记录的属性
			    sortName : 'bno',//排序的属性
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
			$("#add_window").window('open');
		}
		
		//添加图书
		function addBook(){
			$.ajax({
				url:"<%=basePath%>book/addBook",
				type:"post",
				dataType:"json",
				data:{bno:$("#bno").val(),
					  bname:$("#bname").val(),
					  bclass:$("#bclass").val(),
					  beditor:$("#beditor").val(),
					  press:$("#press").val(),
					  pressdate:$("#pressdate").datebox("getValue"),
					  price:$("#price").val(),
					  place:$("#place").val()},
			success:function(res){
				if(res>0){
					$.messager.show({
						title:'My Title',
						msg:'添加成功',
						showType:'show'
					});
					$('#dg').datagrid();
				}else{
					alert("添加失败")
				}
			},
			error:function(){
				alert("出问题了")
				
			}
	
			})
		}
		//删除图书
		function deleteBook(){
			var row=$("#dg").datagrid("getSelected");
		alert(row.bno);
			$.ajax({
				url:"<%=basePath%>book/deleteBook",
				type:"post",
				dateType:"json",
				data:{bno:row.bno} ,
				success:function(res){
					if(res>0){
						$.messager.show({
							title:'My Title',
							msg:'删除成功',
							showType:'show'
						});
						$('#dg').datagrid();
					}else{
							$.messager.show({
								title:'My Title',
								msg:'删除失败',
								showType:'show'
							});
					}
					
				} ,
				error:function(){
					$.messager.show({
						title:'My Title',
						msg:'出问题了',
						showType:'show'
					});
				}
			})
		}
		function openUpdateWindow(){
			
			var row=$("#dg").datagrid("getSelected");
			if(row){
				$("#update_window").window("open");
				$("#updateBook").form("clear");
			$("#updateBook").form("load",row);	
			}
		}
		
		//提示框
		function Msg(msg){
			$.messager.show({
				title:'My Title',
				msg:'出问题了',
				showType:'show'
			});
		}
	</script>
</head>
<body>
	<h2>Custom DataGrid Pager</h2>
	<p>You can append some buttons to the standard datagrid pager bar.</p>
	<div style="margin:20px 0;"></div>
	<table id="dg" title="Custom DataGrid Pager" style="width:900px;height:500px">
		
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'bno',width:80">图书编号</th>
				<th data-options="field:'bname',width:80">图书名字</th>
			    <th data-options="field:'bclass',width:80">图书类别</th>
			    <th data-options="field:'beditor',width:80">作者</th>
			    <th data-options="field:'press',width:80">出版社</th>
			    <th data-options="field:'pressdate',width:80">出版日期</th>
			    <th data-options="field:'price',width:80">价格</th>
			    <th data-options="field:'place',width:80">位置</th>
			    <th data-options="field:'recorddate',width:80">登记日期</th>
			    <th data-options="field:'bstate',width:80">状态</th>
			    <th data-options="field:'bcount',width:80">借出次数</th>
			    
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
			<a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBook()"></a>
		</div>
		<div>
			Date From: <input class="easyui-datebox" style="width:80px">
			To: <input class="easyui-datebox" style="width:80px">
			Language: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>
	<!-- add事件 -->
	    <div  id="add_window" title="添加图书信息" class="easyui-window" style="width:300px;height:300px;"   data-options="modal:true"  closed="true" >
	  <form id="addBook">
         <table>
         <tr>
          <td><lable>图书编号：</lable></td>
          <td><input type="text" name="bno" id="bno" class="easyui-validatebox" required><td>
          <td></td>
         </tr> 
          <tr>
          <td><lable>图书名称：</lable></td>
          <td><input type="text" name="bname" id="bname" class="easyui-validatebox" required><td>
          <td></td>
         </tr> 
                  <tr>
          <td><lable>图书类别：</lable></td>
          <td><input type="text" name="bclass" id="bclass" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>作者：</lable></td>
          <td><input type="text" name="beditor" id="beditor" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版社：</lable></td>
          <td><input type="text" name="press" id="press" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版日期：</lable></td>
          <td><input class="easyui-datebox" name="pressdate" id="pressdate" required></input><td>
         </tr> 
                  <tr>
          <td><lable>价格：</lable></td>
          <td><input type="text" name="price" id="price" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>位置：</lable></td>
          <td><input type="text" name="place" id="place" class="easyui-validatebox" required><td>
         </tr> 
         </table>
         <button id="addbutton" onclick="addBook()">添加图书</button>
	    </form>
	    </div>
	    <!-- update事件 -->
	   <div  id="update_window" title="修改图书信息" class="easyui-window" style="width:300px;height:300px;"   data-options="modal:true"  closed="true" >
	  <form id="updateBook">
         <table>
         <tr>
          <td><lable>图书编号：</lable></td>
          <td><input type="text" name="bno" id="bno" class="easyui-validatebox" ><td>
          <td></td>
         </tr> 
          <tr>
          <td><lable>图书名称：</lable></td>
          <td><input type="text" name="bname" id="bname" class="easyui-validatebox" ><td>
          <td></td>
         </tr> 
                  <tr>
          <td><lable>图书类别：</lable></td>
          <td><input type="text" name="bclass" id="bclass" class="easyui-validatebox" ><td>
         </tr> 
                  <tr>
          <td><lable>作者：</lable></td>
          <td><input type="text" name="beditor" id="beditor" class="easyui-validatebox" ><td>
         </tr> 
                  <tr>
          <td><lable>出版社：</lable></td>
          <td><input type="text" name="press" id="press" class="easyui-validatebox" ><td>
         </tr> 
                  <tr>
          <td><lable>出版日期：</lable></td>
          <td><input class="easyui-datebox" name="pressdate" id="pressdate" ></input><td>
         </tr> 
                  <tr>
          <td><lable>价格：</lable></td>
          <td><input type="text" name="price" id="price" class="easyui-validatebox" ><td>
         </tr> 
                  <tr>
          <td><lable>位置：</lable></td>
          <td><input type="text" name="place" id="place" class="easyui-validatebox" ><td>
         </tr> 
                           <tr>
          <td><lable>登记日期：</lable></td>
           <td><input class="easyui-datebox" name="pressdate" id="pressdate" ></input><td>
         </tr> 
                           <tr>
          <td><lable>状态：</lable></td>
          <td><input type="text" name="bstate" id="bstate" class="easyui-validatebox" ><td>
         </tr> 
                                    <tr>
          <td><lable>借出次数：</lable></td>
          <td><input type="text" name="bcount" id="bcount" class="easyui-validatebox" ><td>
         </tr> 
         </table>
         <button id="updatebutton" onclick="updateBook()">修改图书</button>
	    </form>
	    </div>
	    
	
	
</body>
</html>