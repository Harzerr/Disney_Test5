package utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class MyPicUtiles {
 private static final long serialVersionUID = 1L;
 
 public static  boolean isPic(String fileName) {
		// �汾2007+�ĺ�׺��
		String type = ".jpg";
		// �ļ��ĺ�׺��
		String fileType = fileName.substring(fileName.lastIndexOf("."));

		if (type.equalsIgnoreCase(fileType)) {
			return true;
		}

		return false;
	}
 public Map<String,String> File_upload(HttpServletRequest request,String filepath) {
     //�ж��ϴ��ı��Ƿ�Ϊmultipart/form-data����
     if (ServletFileUpload.isMultipartContent(request)) {

         try {
             //1.����DiskFileItemFactory����,���û�������С����ʱĿ¼�ļ�
             DiskFileItemFactory factory = new DiskFileItemFactory();
             //2.����ServletFileUpload���󣬲������ϴ��ļ��Ĵ�С����
             ServletFileUpload sfu = new ServletFileUpload(factory);
             sfu.setSizeMax(10 * 1024 * 1024);//��byteΪ��λ 1024byte->1KB*1024=1M->1M*10=10M
             sfu.setHeaderEncoding("utf-8");

             //3.����ServletFileUpload.parseRequest�������������󣬵õ�һ�������������ϴ����ݵ�List����
             List<FileItem> fileItemList = sfu.parseRequest(request);
             Iterator<FileItem> fileItems = fileItemList.iterator();

             //����һ��Map���ϣ�������ӱ�Ԫ��
             Map<String, String> map = new TreeMap<String, String>();

             //4.����fileItems��ÿ����һ�����󣬵�����isFormField�����ж��Ƿ����ϴ��ļ�
             while ((fileItems.hasNext())) {
                 FileItem fileItem = fileItems.next();
                 try{
                     //��ͨ�ı�Ԫ��
                     if (fileItem.isFormField()) {
                         String name = fileItem.getFieldName();//name������ֵ
                         String value = fileItem.getString("utf-8");//name��Ӧ��valueֵ
                         //��ӽ�Map������
                         map.put(name, value);
                     } else {//����Ϊ<input type="file">�ϴ����ļ�
                         if(fileItem.getName()==null||fileItem.getFieldName()==null){
                             map.put("fileName","empty");
                             map.put("newFileName","empty");
                         }else {
                             String fileName = fileItem.getName();// �ļ�����
                             System.out.println("ԭ�ļ�����" + fileName);// Koala.jpg

                             String suffix = fileName.substring(fileName.lastIndexOf('.'));
                             System.out.println("��չ����" + suffix);// .jpg

                             // ���ļ�����Ψһ��
                             String newFileName = new Date().getTime() + suffix;
                             System.out.println("���ļ�����" + newFileName);// image\1478509873038.jpg

                             //���ļ������뵽������
                             map.put("fileName", fileName);
                             map.put("newFileName", newFileName);


                             // 5. ����FileItem��write()������д���ļ�
                             String context = filepath+newFileName ;
                             System.out.println("ͼƬ��·��Ϊ"+context);
                             File file = new File(context);
                             System.out.println(file.getAbsolutePath());
                             fileItem.write(file);

                             //�жϸ��ļ��Ƿ�Ϊhead_img��Ĭ�ϵ�ͷ��������ǲ�ִ��ɾ��
                             if(!fileName.contains("empty")|| !newFileName.contains("empty")){
                                 // 6. ����FileItem��delete()������ɾ����ʱ�ļ�
                                 fileItem.delete();
                             }

                         }

                     }
                 }catch (StringIndexOutOfBoundsException e ){
                     //��Ϊ��ָָ��
                     //δ�ϴ�ͼƬ��ԭ����ͼƬ��ʾ
                     //����Ϊfalse,�ڽ������ݿ����ʱ����ͼƬ���в���
                     System.out.println("�����쳣");
                     map.put("fileName","empty");
                     map.put("newFileName","empty");
                     e.printStackTrace();
                 }

             }
             return map;
         } catch (FileUploadException e) {
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     return  null;
 }

}
