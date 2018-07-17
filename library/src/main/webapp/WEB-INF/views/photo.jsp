<%@ page language="java" contentType="text/html; charset=UTF-8"   
    pageEncoding="UTF-8"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	
	<%@ include file="include.jsp" %>
	<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>css/bootstrap-fileinput.css" rel="stylesheet">
	
</head>
<body>
 
<div class="container">
    <div class="page-header">
        <h3>FormData图片上传</h3>
        <form id="uploadForm" enctype='multipart/form-data'>
            <div class="form-group" >
                <div class="h4">图片预览</div>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="<%=basePath %>image/noimage.png" alt="" />
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
            <button type="button" id="uploadSubmit" class="btn btn-info">提交</button>
        </form>
    </div>
</div>
 <image src="<%=basePath%>photo/getImage?bookid=1" style="width:150px;height:150px"/>


<script src="<%=basePath %>js/easyUI/bootstrap-fileinput.js"></script>
<script type="text/javascript">
    $(function () {
    	
        //比较简洁，细节可自行完善
        $('#uploadSubmit').click(function () {
        	//alert($("#picID").val())
            var FormDate = new FormData($('#uploadForm')[0]);
        	alert($('#uploadForm')[0])
            $.ajax({
                url: '<%=basePath%>photo/uploadPhoto ',
                type: 'POST',
                data: FormDate,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (res) {
                   if(res>0){
                	   alert("上传成功")
                   }
                    else{
                       alert("上传失败")
                    }
                },
                error: function (res) {
                	 alert("上传失败")
                }
            });
        });

    })
</script>

</body>
</html>