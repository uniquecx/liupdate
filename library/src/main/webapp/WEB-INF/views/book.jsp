<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	
	<%@ include file="include.jsp" %>
	<script>
	$(function(){
		 $('#dg').datagrid({
			url:'<%=basePath%>book/getBook',
		    idField: "bookid",//一般对应主键唯一标示行记录的属性
		    sortName : 'bookid',//排序的属性
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
	
		
	
	 function searchbook(){
		 alert($("#bookclass").combobox('getValue'));
		$("#dg").datagrid('load',{
			bname:$("#bname").val(),
			type:$("#bookclass").combobox('getValue'),
			sts:$("#sts").combobox('getValue'),
			mindate:$("#mindate").datebox("getValue"),maxdate:$("#maxdate").datebox("getValue")
		})
	} 
	function openAddWindow(){
		$("#add_window").window("open");
	}
	
	//添加图书
	 function addBook(){
		var typeclass=$("#addclass").combobox('getValue');
		alert($("#addauthor").val())
		
		if(typeclass==""){
			Msg("请选择图书类别")
		}else{
		$.ajax({
			url:"<%=basePath%>book/addBook",
			type:"post",
			dataType:"json",
			data:{
				  bookname:$("#addbname").val(),
				  typeclass:$("#addclass").combobox('getValue'),
				  author:$("#addauthor").val(),
				  press:$("#addpress").val(),
				  pressdate:$("#addpressdate").datebox("getValue"),
				  price:$("#addprice").val(),
				  isbn:$("#addisbn").val(),
				  place:$("#addplace").val()},
		success:function(res){
			if(res>0){
				Msg("添加成功")
				$('#dg').datagrid();
			}else{
				Msg("添加失败")
			}
		},
		error:function(){
			Msg("出问题了")
			
		}
		})
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
	
	function openImportWindow(){
		$("#add_import").window("open");
	}
	function uploadExcel(){
		//得到上传文件的全路径  
        var fileName= $('#uploadExcel').filebox('getValue');
        if(fileName==""){     
            Msg("请选择上传excl")
         }else{  
             //对文件格式进行校验  
             var d1=/\.[^\.]+$/.exec(fileName);   
             if(d1==".xlsx"||d1==".xls"){  
 
            	$("#uploadname").val($('#uploadExcel').filebox('getValue'));
            	alert($("#uploadname").val());
                  //提交表单  
                  $("#BookManage").submit();
                      
                 Msg("上传成功")        
            }else{  
               Msg("请选择ecxl格式文件")  
                $('#uploadExcel').filebox('setValue','');   
            }  
             

  }  
	}
	/* function ExporterExcel() {
	    //获取Datagride的所有数据集合
	    var rows = $('#dg').datagrid("getRows");
	    var columns = $('#dg').datagrid("options").columns[0];
	    //创建AX对象excel
	    var oXL = new ActiveXObject("Excel.Application");
	    //获取workbook对象
	    var oWB = oXL.Workbooks.Add();
	    //激活当前sheet
	    var oSheet = oWB.ActiveSheet;
	    //设置工作薄名称  
	    oSheet.name = "导出Excel报表";
	    for (var i = 0; i < columns.length; i++) {
	        oSheet.Cells(1, i + 1).value = columns[i].title;
	    }
	    for (var i = 0; i < rows.length; i++) {
	        for (var j = 0; j < columns.length; j++) {
	            if (rows[i][columns[j].field] != null) {
	                oSheet.Cells(i + 2, j + 1).value = rows[i][columns[j].field].toString();
	            } else {
	                oSheet.Cells(i + 2, j + 1).value = "";
	            }
	        }
	    }
	    //设置excel可见属性
	    oXL.Visible = true;
	} */
	function openExportWindow(){
		$("#exportWindow").window("open");
	}
	//导出excel
	function exportBook(){
		var exportroad=$("#exportroad").val();
		var filename=$("#filename").val();
		alert($("#bookclass").combobox('getValue'))
		if(exportroad==""){
			Msg("请输入路径")
		}else{
			if(filename==""){
				Msg("请输入文件名")
			}else{
				$.ajax({
					url:"<%=basePath%>book/exportBook",
					type:"post",
					dataType:"json",
					data:{bname:$("#bname").val(),
						type:$("#bookclass").combobox('getValue'),
						mindate:$("#mindate").datebox("getValue"),maxdate:$("#maxdate").datebox("getValue"),
						exportroad:$("#exportroad").val(),filename:$("#filename").val()},
						success:function(res){
							if(res>0){
								Msg("导出成功")
								$('#dg').datagrid();
								
							}else{
								Msg("导出失败")
							}
						}
					
				})
			}
		}
		
	}
	
		//删除图书
			function deleteBook(){
			var ids=[];
				var rows=$("#dg").datagrid("getChecked");
				
				alert(rows.length)
				if(rows!=""){
					$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
						if (!r) { 
						return; 
						} 
					
					for(var i=0;i<rows.length;i++){
						ids.push(rows[i].bookid);
			}
					alert(ids);
				$.ajax({
					url:"<%=basePath%>book/deleteBook",
					type:"post",
					dateType:"json",
					data:{ids:JSON.stringify(ids)} ,//格式化数组
					success:function(res){
						if(res>0){
							Msg("在库图书删除成功");
							
							$('#dg').datagrid("reload")//重新加载 ;
							
						}else{
							Msg("请确认图书都在库")

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
			var rows=$("#dg").datagrid("getChecked");
			if(rows!=""){
				if(rows.length==1){
				$("#update_window").window("open");
				  var row=rows[0];
				  alert(row)
				  $("#updateBook").form("clear");
				  $('#updateBookform').form('load',row);
				  
				}else{
					Msg("请不要选择多行")
				}
			}else{
				Msg("请选择一行修改")
			}
			
		}
		 function updateBook(){
		
			alert($("#bookname").val())
		
			 $.ajax({
				 url:"<%=basePath%>book/updateBook",
			     type:"post",
			     dataType:"json",
			     data:{bookid:$("#bookid").val(),
			    	   bookname:$("#bookname").val(),
			    	   type:$("#type").combobox('getValue'),
			    	   author:$("#author").val(),
			    	   press:$("#press").val(),
			    	   pressdate:$("#pressdate").datebox("getValue"),
			    	   price:$("#price").val(),
			    	   isbn:$("#isbn").val(),
			    	   place:$("#place").val()
			     },
			     success:function(res){
			    	 if(res>0){
			    		 Msg("修改成功");
			    		 $('#dg').datagrid();
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
	<table id="dg" style="width:1000px;height:400px">
		
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'bookid',width:80">图书编号</th>
				<th data-options="field:'bookname',width:80">图书名称</th>
			    <th data-options="field:'type',width:80">图书类别</th>
			    <th data-options="field:'press',width:80">出版社</th>
			    <th data-options="field:'pressdate',width:80">出版日期</th>
			    <th data-options="field:'author',width:80">作者</th>
			    <th data-options="field:'price',width:80">价格</th>
			    <th data-options="field:'isbn',width:80">索书号</th>
			    <th data-options="field:'status',width:80">状态</th> 
			    <th data-options="field:'place',width:80">图书位置</th> 
			    <th data-options="field:'gdate',width:80">还书日期</th> 
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAddWindow()"></a>
			<a id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdateWindow()"></a>
			
			
			
		  <a id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBook()"></a>
		  <a id="import" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="openImportWindow()"></a>
		  <a id="export" class="easyui-linkbutton" iconCls="icon-print" plain="true" onclick="openExportWindow() "></a>
		</div>
		<div>
		
		    图书名称:<input class="easyui-validatebox" style="width:80px" name="bname" id="bname">
		    图书类别:
<input class="easyui-combobox" 
			name="bookclass" id="bookclass" 
			data-options="
					url:'<%=basePath %>book/getBookClass', 
					method:'get',
					valueField:'text',
					textField:'text',
					panelHeight:'auto'
			">
       状态:
<select class="easyui-combobox" name="sts" id="sts" style="width:100px;">
         <option value="">--请选择--</option>
		<option value="在库">在库</option>
		<option value="不在库">不在库</option>
	</select>

   
			出版日期: <input class="easyui-datebox" style="width:150px" id="mindate" name="minadte">
			到: <input class="easyui-datebox" style="width:150px" id="maxdate" name="maxdate">
		
			<a onclick="searchbook()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		
		</div>
	</div>
	<!-- add事件 -->
	    <div  id="add_window" title="添加图书信息" class="easyui-window" style="width:300px;height:300px;"   data-options="modal:true"  closed="true" >
	  <form id="addBook">
         <table>
          <tr>
          <td><lable>图书名称：</lable></td>
          <td><input type="text" name="addbname" id="addbname" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>图书类别：</lable></td>
          <td><input class="easyui-combobox" 
			name="addclass" id="addclass" 
			data-options="
					url:'<%=basePath %>book/getBookClass',
					method:'get',
					valueField:'text',
					textField:'text',
					panelHeight:'auto'
			"></td>
         </tr> 
                  <tr>
          <td><lable>作者：</lable></td>
          <td><input type="text" name="addauthor" id="addauthor" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版社：</lable></td>
          <td><input type="text" name="addpress" id="addpress" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版日期：</lable></td>
          <td><input class="easyui-datebox" name="addpressdate" id="addpressdate" required></input><td>
         </tr> 
                  <tr>
          <td><lable>价格：</lable></td>
          <td><input type="text" name="addprice" id="addprice" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>isbn：</lable></td>
          <td><input type="text" name="addisbn" id="addisbn" class="easyui-validatebox" required><td>
         </tr> 
           <tr>
          <td><lable>图书位置：</lable></td>
          <td><input type="text" name="addplace" id="addplace" class="easyui-validatebox" required><td>
         </tr> 
         </table>
     
         <button id="addbutton" onclick="addBook()">添加图书</button>
	    </form>
	    </div>
	    <!-- 批量导入窗口-->
	    <div  id="add_import" title="批量导入" class="easyui-window" style="width:500px;height:300px;"   data-options="modal:true"  closed="true" >
	  
	 <form id="BookManage"  method="post"  action="<%=basePath%>book/importBook">  
                选择文件：　<input id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:400px" data-options="prompt:'请选择文件...'">  
      <input id="uploadname" name="uploadname" type="hidden">
       　　<a  class="easyui-linkbutton" style="width:122px" onclick="uploadExcel()" >导入图书</a> 　　     　　　　　      
 
     </form>   
	    </div>
	    <!--数据导出export -->
	    <div id="exportWindow" title="导出excel"   class="easyui-window" style="width:500px;height:300px;"   data-options="modal:true"  closed="true" >
	    
	    输入导出路径：<input type="text" name="exportroad" id="exportroad" class="easyui-validatebox" required>
	    <br>
	    输入文件名：<input type="text" name="filename" id="filename" class="easyui-validatebox" required><br>
	    <input type="button" value="导出" onclick="exportBook()">
	    
	    </div>
	    <!-- 修改1条数据 -->
	    <div  id="update_window" title="修改图书信息" class="easyui-window" style="width:350px;height:300px;"   data-options="modal:true"  closed="true" >
	  <form id="updateBookform">
         <table>
         <input type="hidden" name="bookid" id="bookid">
          <tr>
          <td><lable>图书名称：</lable></td>
          <td><input type="text" name="bookname" id="bookname" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>图书类别：</lable></td>
          <td><input class="easyui-combobox" 
			name="type" id="type"  
			data-options="
					url:'<%=basePath %>book/getBookClass',
					method:'get',
					valueField:'text',
					textField:'text',
					panelHeight:'auto'
			"></td>
         </tr> 
                  <tr>
          <td><lable>作者：</lable></td>
          <td><input type="text" name="author" id="author" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版社：</lable></td>
          <td><input type="text" name="press" id="press" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>出版日期：</lable></td>
          <td><input class="easyui-datebox" name="pressdate" id="pressdate" required></input>
          <label style="color:red">小于当前时间</label>
          <td>
         </tr> 
                  <tr>
          <td><lable>价格：</lable></td>
          <td><input type="text" name="price" id="price" class="easyui-validatebox" required><td>
         </tr> 
                  <tr>
          <td><lable>isbn：</lable></td>
          <td><input type="text" name="isbn" id="isbn" class="easyui-validatebox" required><td>
         </tr> 
          <tr>
          <td><lable>图书位置：</lable></td>
          <td><input type="text" name="place" id="place" class="easyui-validatebox" required><td>
         </tr> 
                  
         </table>
         <button id="updatebutton" onclick="updateBook()">修改图书</button>
	    </form>
	    </div>
	    
</body>
