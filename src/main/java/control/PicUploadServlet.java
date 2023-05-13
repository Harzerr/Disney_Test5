package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.StudentModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import utils.MyPicUtiles;

@MultipartConfig
@WebServlet("/PicUploadServlet")
public class PicUploadServlet extends HttpServlet {
    //为类可持久化
    private static final long serialVersionUID = 1L;
    public PicUploadServlet(){
		super();
		// TODO Auto-generated constructor stub
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  Part picPart = request.getPart("pic");
    	  int id = Integer.parseInt(request.getParameter("id"));
    	  StudentModel model = new StudentModel();
	 	    
          if (picPart != null){
              String fileName = picPart.getSubmittedFileName();
              if (MyPicUtiles.isPic(fileName)) {
                  //为了避免文件重名,给它重新命名
                  fileName = id + "_" + fileName;
                  //获取文件存放目录的真实路径
                  String dirPath = this.getServletContext().getRealPath("/img");
                  //保存文件
                  picPart.write(dirPath + "/" + fileName);
                  model.addPic(id, fileName);
              }
          }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
