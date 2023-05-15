<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传相片信息</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    
</head>
<style>
	#img-preview{
		max-width:200px;
		max-height: 300px;
		min-width:50px;
		min-height: 50px;
		border-radius:5px;
		background-color: #eee;
	}
</style>
<body>
  
 <center>
		<h1>插入相片信息</h1>
		<h1 id="msg"></h1>
			
			<form action="PicUploadServlet.do" method="post" enctype="multipart/form-data">

				<p>学号: <input type="text" name="id"></p>
				<p>
				  <input id="file-input" type="file" name="pic"/>
				  <input type="submit" value="上传">
				<br></p>
				<img  id="img-preview" alt="请选择相片" src="">
				
			</form>
			<script>
				let fileInput = document.getElementById("file-input");
				let img = document.getElementById("img-preview");
				fileInput.onchange = (e)=>{
					let file = fileInput.files[0];
					if(file != undefined){
						if(file.type.lastIndexOf("image/") > -1){
							let uri = URL.createObjectURL(file);
							img.src = uri;
						}else {
							img.src = "";
							fileInput.value = "";
							alert("仅支持图片格式文件")
						}
					}else {
						img.src = "";
						fileInput.value = "";
						alert("用户取消操作")
					}
				}

			</script>
     </center>
   
</body>

</html>
