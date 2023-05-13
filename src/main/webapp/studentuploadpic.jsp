<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传相片信息</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    
</head>
<body>
  
 <center>
		<h1>插入相片信息</h1>
		<h1 id="msg"></h1>
			
			<form action="PicUploadServlet.do" method="post" enctype="multipart/form-data">

				<p>学号: <input type="text" name="id"></p>
				<p>  相片:
					<img width="100" height="100"  alt="当前尚未上传头像"> 
				  <input type="file" name="picpath" />
				  <input type="submit" value="上传">
				<br></p>
				
			</form>
     </center>
   
</body>

</html>
