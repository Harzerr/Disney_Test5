<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>����ѧ����Ϣ</title>
    
  </head>
  
  <body>
  
 <center>
		<h1>����ѧ����Ϣ</h1>
			<form action="${pageContext.request.contextPath }/InsertStudentservlet.do" method="post" enctype="multipart/form-data">

				<p>ѧ��: <input type="text" name="id"></p>
				<p>����:
				<input type="text" name="name" />
				<br></p>
				<p>�Ա�:
				<input type="text" name="sex" />
				<br></p>
                <p> ����:
				<input type="text" name="age" />
				<br></p>
                <p>  �༶:
				<input type="text" name="grade" />
				<br></p>
                <p>  �ɼ�:
				<input type="text" name="score" />
				<br></p>
				<p>  ��Ƭ:
				  <input type="file" name="picpath" value = "file"/>
				  <input type="submit" value="�ϴ�">
				<br></p>
				<input type="submit" value="�ύ" />
				<input type="reset" value="����" />
			</form>
     </center>
  </body>
  
</html>
