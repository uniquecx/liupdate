<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
<Script>

function openTable(){
	
	if($("#dgtable").css("display")=="none"){
		$("#dgtable").css("display","block");
		var bookid=$("#addbookid").val();
		alert(bookid)
		
		$('#dg').datagrid({
			url:'<%=basePath%>borrow/getBook',
			queryParams: {
				bookid: bookid,
			},
		    idField: "bookid",//一般对应主键唯一标示行记录的属性
		    sortName : 'bookid',//排序的属性
			sortOrder : 'asc',
		    rownumbers: true,//是否显示行序号
		    method:'get',
		    cache:false,
		  
		   // fit: true,//是否自适应界面宽高
		    singleSelect:true,//是否能多行选择
		   
		    checkOnSelect: true, selectOnCheck: false,		
		  onDblClickRow: function () {  
			     var row=$("#dg").datagrid('getSelected');
			     $('#borrow').form('load', row);
			     $("#dgtable").css("display","none");
					$('#dg').datagrid('loadData', { total: 0, rows: [] });  
			  }
		})
	}else{
		$("#dgtable").css("display","none");
		$('#dg').datagrid('loadData', { total: 0, rows: [] });  
	}
	
}
function openTables(){
	
	if($("#dgtables").css("display")=="none"){
		$("#dgtables").css("display","block");
		var readerid=$("#addreaderid").val();
		alert(bookid)
		
		$('#dgs').datagrid({
			url:'<%=basePath%>borrow/getReader',
			queryParams: {
				readerid: readerid,
			},
		    idField: "readerid",//一般对应主键唯一标示行记录的属性
		    sortName : 'readerid',//排序的属性
			sortOrder : 'asc',
		    rownumbers: true,//是否显示行序号
		    method:'get',
		    cache:false,
		  
		   // fit: true,//是否自适应界面宽高
		    singleSelect:true,//是否能多行选择
		   
		    checkOnSelect: true, selectOnCheck: false,		
		  onDblClickRow: function () {  
			     var row=$("#dgs").datagrid('getSelected');
			     $('#borrow').form('load', row);
			     $("#photo").attr("src",$("#imgpath").val()+row.photo)
			     $("#dgtables").css("display","none");
					$('#dgs').datagrid('loadData', { total: 0, rows: [] });  
			  }
		})
	}else{
		$("#dgtables").css("display","none");
		$('#dgs').datagrid('loadData', { total: 0, rows: [] });  
	}
	
}
$(function(){
	$('#dgx').datagrid({
		url:'<%=basePath%>borrow/getBorrow',
	    idField: "bid",//一般对应主键唯一标示行记录的属性
	    sortName : 'bid',//排序的属性
		sortOrder : 'desc',
	    rownumbers: true,//是否显示行序号
	    method:'get',
	   // fit: true,//是否自适应界面宽高
	    singleSelect:true,//是否能多行选择
	    pagination:true,//是否分页操作
        pageSize: 10,         //分页大小  
        pageNumber:1,         //第几页显示（默认第一页，可以省略）  
        pageList: [10, 20, 30], //设置每页记录条数的列表  
        checkOnSelect: true, selectOnCheck: false,
		 
	 });	
	
})
function borrowBook(){
	var  bookid=$("#bookid").val();
	var readerid=$("#readerid").val();
	if(bookid==""){
		Msg("先选择图书")
	}else{
		if(readerid==""){
			Msg("先选择读者")
		}else{
                alert($("#rname").val())
			$.messager.confirm('提示', '是否借书?', function (r) { 
				if (!r) { 
				return; 
				} 
		  $.ajax({
			  url:"<%=basePath%>borrow/borrowBook",
			  type:"post",
			  dataType:"JSON",
			  data:{bookid:$("#bookid").val(),
				    bookname:$("#bookname").val(),
				    readerid:$("#readerid").val(),
				    rname:$("#rname").val(),
				    phone:$("#phone").val()},
			  success:function (res){
				  if(res>0){
					  $("#dgx").datagrid("reload");
					  Msg("借书成功")
				  }else{
					  Msg("借书失败")
				  }
			  },error:function(){
				  Msg("出问题了")
			  }
			  
		  })
		  
				
			})
		}
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
	function renew(){
		var  bookid=$("#bookid").val();
		var readerid=$("#readerid").val();
		if(bookid==""){
			Msg("先选择图书")
		}else{
			if(readerid==""){
				Msg("先选择读者")
			}else{

				$.messager.confirm('提示', '是否续借?', function (r) { 
					if (!r) { 
					return; 
					} 
			  $.ajax({
				  url:"<%=basePath%>borrow/renew",
				  type:"post",
				  dataType:"JSON",
				  data:{bookid:$("#bookid").val(),
					    readerid:$("#readerid").val(),
				  },
				  success:function (res){
					  if(res>0){
						  $("#dgx").datagrid("reload");
						  Msg("续借成功")
					  }else{
						  Msg("续借失败")
					  }
				  },error:function(){
					  Msg("出问题了")
				  }
				  
			  })
			  
					
				})
			}
		}
		
	}

</Script>
</head>
<body>
<center>
<div style="width:900px;height:300px" >
<input type="hidden" value="<%=imgPath%>" id="imgpath"> 
<h2>图书借阅</h2> <input type="button" value="借书" onclick="borrowBook()">
<input type="button" value="还书" >
<input type="button" value="续借" onclick="renew()">
    <form id="borrow">
    <table style="width:900px;" >  
      <tr>
       	<td style="width:80px;height:40px" >选择图书:</td>
        <td style="width:300px" ><input type="text"  name="addbookid" id="addbookid"> 	
		<input type="button" value="加载" onclick="openTable()" >
		<div id="dgtable" style="display:none; position: absolute;
		">
	<table id="dg" style="width:300px;height:200px;" >
		
		<thead>
			<tr>
			 
				<th data-options="field:'bookid',width:80">图书编号</th>
				<th data-options="field:'bookname',width:80">图书名称</th>
			    <th data-options="field:'type',width:80">图书类别</th>
			    <th data-options="field:'press',width:80">出版社</th>
			    <th data-options="field:'pressdate',width:80">出版日期</th>
			    <th data-options="field:'author',width:80">作者</th>
			    <th data-options="field:'price',width:80">价格</th>
			    <th data-options="field:'isbn',width:80">isbn</th>
			    <th data-options="field:'status',width:80">状态</th> 
			    <th data-options="field:'place',width:80">图书位置</th> 
			</tr>
		</thead>
	</table>
    </div></td>
        <td style="width:80px">选择读者:</td>
        
          <td style="width:300px" ><input type="text"  name="addreaderid" id="addreaderid"> 		
        <input type="button" value="加载" onclick="openTables()" >
		<div id="dgtables" style="display:none;position: absolute;">
	<table id="dgs" style="width:300px;height:200px;" >
		
		<thead>
			<tr>
	         <th data-options="field:'readerid',width:80">读者编号</th>
				<th data-options="field:'rname',width:80">姓名</th>
				<th data-options="field:'readertype',width:80">读者类别</th>
				<th data-options="field:'sex',width:80">性别</th>
				<th data-options="field:'phone',width:80">联系方式</th>
				<th data-options="field:'photo',width:80">照片</th>
				<th data-options="field:'number',width:80">已借本数</th>
			</tr>
		</thead>
	</table>
    </div></td>
        <td rowspan="4" style="width:140px;">
        <img alt="" src="<%=basePath %>image/noimage.png" id="photo" style="max-width:140px">
        </td>
      <tr>
       <tr>
       	<td style="height:40px">图书编号:</td>
        <td><input type="text" name="bookid" id="bookid"  disabled="disabled"></td>
        <td>读者编号:</td>
        <td><input type="text" name="readerid" id="readerid"  disabled="disabled"></td>
      <tr>
       <tr>
       	<td style="height:40px">图书名称:</td>
        <td><input type="text" name="bookname" id="bookname"  disabled="disabled"></td>
        <td>读者姓名:</td>
        <td><input type="text" name="rname" id="rname"  disabled="disabled"></td>
      <tr>
       <tr>
       	<td style="height:40px">图书位置:</td>
        <td><input type="text" name="place" id="place"  disabled="disabled"></td>
        <td>读者手机:</td>
        <td><input type="text" name="phone" id="phone"  disabled="disabled"></td>
      <tr>
    </table>
    </form>
    </div> 
   <h2>借阅记录</h2>
	<table id="dgx" style="width:1100px;height:400px">
		
		<thead>
			<tr>
				 <th data-options="field:'bid',width:80">借阅编号</th>
				<th data-options="field:'bookid',width:80">图书编号</th>
				<th data-options="field:'bookname',width:80">图书名称</th>
				<th data-options="field:'readerid',width:80">读者编号</th>
				<th data-options="field:'rname',width:80">读者姓名</th>
				<th data-options="field:'phone',width:80">联系方式</th>
				<th data-options="field:'jdate',width:80">借书日期</th>
				<th data-options="field:'ydate',width:80">应还日期</th>
				<th data-options="field:'gdate',width:80">归还日期</th>
				<th data-options="field:'back',width:80">是否归还</th>
				<th data-options="field:'count',width:80">续借次数</th>
				<th data-options="field:'jadmin',width:80">借出操作员</th>
				<th data-options="field:'gadmin',width:80">归还操作员</th>
			</tr>
		</thead>
	</table>
</center>
</body>
</html>