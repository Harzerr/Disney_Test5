package control;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jxl.Image;
import model.StudentModel;
import utils.MyPicUtiles;
@MultipartConfig
@WebServlet("/Insertservlet")
public class Insertservlet extends HttpServlet {

	public Insertservlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("gbk");
	 		int id = Integer.parseInt(request.getParameter("id"));
	 		String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String grade = request.getParameter("grade");
			float score = Float.parseFloat(request.getParameter("score"));
			Part part = request.getPart("pic");
			//String picpath = request.getParameter("picpath");
//			String pisname;
//			String pictype;
//			File file ;
//			Image 
			
     		StudentModel model = new StudentModel();
	 	    //model.insert(id, name, sex, age, grade, score, picpath);
     		int i = model.insert(id, name, sex, age, grade, score);
     		System.out.println(i);
     		 if (part != null && i > 0){
                 String fileName = part.getSubmittedFileName();
                 System.out.println(fileName);
                 if (MyPicUtiles.isPic(fileName)) {
                     //为了避免文件重名,给它重新命名
                     fileName = id + "_" + fileName;
                     //获取文件存放目录的真实路径
                     String dirPath = request.getServletContext().getRealPath("/static/upload/");
                     System.out.println(request.getServletContext());
                     //保存文件
                     part.write(dirPath + fileName);
                     part.delete();
                     System.out.println(dirPath+fileName);
                     model.addPic(id, "./static/upload/"+fileName);
                 }
             }
	 	    response.sendRedirect("ListStudentServlet.do");
	}

}
