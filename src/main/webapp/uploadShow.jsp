<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>上传数据</title>
</head>
<body>
	<h1 id="msg"></h1>
	<script type="text/javascript">
		let msg = "${msg}";
		let msgDom = document.getElementById("msg");
		msgDom.innerHTML = msg;
	</script>
	<form action="${pageContext.request.contextPath }/ListStudentservlet.do" >
		<input type="submit" value="显示所有学生">
	</form>
</body>
</html>
