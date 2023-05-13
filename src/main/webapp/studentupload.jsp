
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>通过excel文件批量添加</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/uploadServlet"
		method="post" enctype="multipart/form-data">
		<input type="file" name="excelFile"  accept=".xls, .xlsx"/>
		<input type="submit" value="上传">
	</form>
</body>
</html>


