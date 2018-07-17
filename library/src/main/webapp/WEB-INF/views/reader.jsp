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
			url:'<%=basePath%>reader/getReader',
		    idField: "readerid",//一般对应主键唯一标示行记录的属性
		    sortName : 'readerid',//排序的属性
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

function addReader(){
	if($("#addreadertype").combobox('getValue')==""){
		Msg("请添加读者类别")
	}else{
      $.ajax({
          url: '<%=basePath%>reader/addReader',
          type: 'POST',
          dataType:"JSON",
          data: {rname:$("#addrname").val(),
        	     readertype:$("#addreadertype").combobox('getValue'),
        	     sex:$("#addsex").combobox('getValue'),
        	     phone:$("#addphone").val(),
        	     file:$("#file").val()},
          success: function (res) {
             if(res>0){
          	   Msg("添加成功");
             }
              else{
            	  Msg("添加失败");
              }
          },
          error: function (res) {
        	  Msg("出问题了")
          }
      });
	
}
}
function openUpdateWindow(){
	var rows=$("#dg").datagrid("getChecked");
	if(rows!=""){
		if(rows.length==1){
		$("#update_window").window("open");
		  var row=rows[0];
		  alert(row)
		  $("#updatereader").form("clear");
		  alert(row.photo)
		  $('#updatereader').form('load',row);
		  $("#photo").attr("src",$("#imgPath").val()+row.photo)
		  
		}else{
			Msg("请不要选择多行")
		}
	}else{
		Msg("请选择一行修改")
	}
	
	
}
function updateReader(){
	alert($("#updatefile").val())
	 $.ajax({
         url: '<%=basePath%>reader/updateReader ',
         type: 'POST',
         dataType:"JSON",
         data: {readerid:$("#readerid").val()
        	 ,rname:$("#rname").val(),
       	     readertype:$("#readertype").combobox('getValue'),
       	     sex:$("#sex").combobox('getValue'),
       	     phone:$("#phone").val(),
       	     file:$("#updatefile").val()},
         success: function (res) {
            if(res>0){
         	   Msg("修改成功")
            }
             else{
           	  Msg("修改失败")
             }
         },
         error: function (res) {
       	  Msg("出问题")
         }
     });
	
	
}
//删除读者
function deleteReader(){
var ids=[];
	var rows=$("#dg").datagrid("getChecked");
	
	alert(rows.length)
	if(rows!=""){
		$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
			if (!r) { 
			return; 
			} 
		
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].readerid);
}
		alert(ids);
	$.ajax({
		url:"<%=basePath%>reader/deleteReader",
		type:"post",
		dateType:"json",
		data:{ids:JSON.stringify(ids)} ,//格式化数组
		success:function(res){
			if(res>0){
				Msg("删除成功");
				
				$('#dg').datagrid("reload")//重新加载 ;
				
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
//提示框
function Msg(msg){
	$.messager.show({
		title:'消息',
		msg:msg,
		showType:'show'
	});
}
	
	</Script>
</head>
<body>
 <div style="margin:20px 0;"></div>
 <input type="hidden" id="imgPath" value="<%=imgPath%>">
	<table id="dg" style="width:1000px;height:400px">
		
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'readerid',width:80">读者编号</th>
				<th data-options="field:'rname',width:80">姓名</th>
				<th data-options="field:'readertype',width:80">读者类别</th>
				<th data-options="field:'sex',width:80">性别</th>
				<th data-options="field:'phone',width:80">联系方式</th>
				<th data-options="field:'photo',width:80">照片</th>
					<th data-options="field:'number',width:80">已借本数</th>
			</tr>
		</thead>
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
		  <a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteReader()"></a>
		  </div>
	</table>
		<!-- add事件 -->
	    <div  id="add_window" title="添加读者" class="easyui-window" style="width:500px;height:500px;"   data-options="modal:true"  closed="true" >
	  <form id="addreader" >
         <table>
                  <tr>
          <td><lable>作者姓名：</lable></td>
          <td><input type="text" name="addrname" id="addrname" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>读者类别：</lable></td>
          <td><input class="easyui-combobox" id="addreadertype"
			name="addreadertype" style="width:140px;" 
			data-options="
					url:'<%=basePath %>reader/getType',
					method:'get',
					valueField:'text',
					textField:'text',
					panelHeight:'auto'
			"><td>
         </tr> 
                  <tr>
          <td><lable>性别：</lable></td>
          <td><select id="addsex" name="addsex" class="easyui-combobox"style="width:100px;"  >
          <option value="男">男</option>
          <option value="女">女</option>
          </select><td>
         </tr> 
                  <tr>
          <td><lable>联系方式：</lable></td>
          <td><input type="text" name="addphone" id="addphone" class="easyui-validatebox" required><td>
         </tr> 
          <input type="hidden" name="filepath" id="filepath">
         </table>
        <div class="container">
    <div class="page-header">
            <div class="form-group" >
                <div class="h4">图片预览</div>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="<%=basePath%>image/noimage.png" alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="file" accept="image/gif,image/jpeg,image/x-png">
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>   
    </div>
</div>
         <button id="addbutton" onclick="addReader()">添加读者</button>
	    </form>
	    </div>
	    
	    <!-- update -->
	     <div  id="update_window" title="修改读者" class="easyui-window" style="width:500px;height:500px;"   data-options="modal:true"  closed="true" >
	  <form id="updatereader" >
	  <input  type="hidden" name="readerid" id="readerid" > 
         <table>
                  <tr>
          <td><lable>作者姓名：</lable></td>
          <td><input type="text" name="rname" id="rname" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>读者类别：</lable></td>
          <td><input class="easyui-combobox" id="readertype"
			name="readertype" style="width:140px;" 
			data-options="
					url:'<%=basePath %>reader/getType',
					method:'get',
					valueField:'text',
					textField:'text',
					panelHeight:'auto'
			"><td>
         </tr> 
                  <tr>
          <td><lable>性别：</lable></td>
          <td><select id="sex" name="sex" class="easyui-combobox"style="width:100px;">
          <option value="男">男</option>
          <option value="女">女</option>
          </select><td>
         </tr> 
                  <tr>
          <td><lable>联系方式：</lable></td>
          <td><input type="text" name="phone" id="phone" class="easyui-validatebox" required><td>
         </tr> 
         
         </table>
        <div class="container">
    <div class="page-header">
            <div class="form-group" >
                <div class="h4">照片</div>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='photo' style="width: 100%;height: auto;max-height: 140px;" src="<%=basePath%>image/noimage.png" alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="updatefile" id="updatefile" accept="image/gif,image/jpeg,image/x-png">
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>   
    </div>
</div>
         <button id="updtebutton" onclick="updateReader()">修改信息</button>
	    </form>
	    </div>
	    

</body>
</html>