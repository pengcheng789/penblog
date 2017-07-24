package top.pengcheng789.java.penblog.service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pen on 17-7-10.
 */
public class UploadHeadImgService {
    public static UploadHeadImgService instance;

    private UploadHeadImgService(){
    }

    public static UploadHeadImgService getInstance(){
        if (instance == null){
            instance = new UploadHeadImgService();
        }

        return instance;
    }

    public boolean uploadHeadImg(HttpServletRequest request, String userId)
            throws IOException {
        boolean result = false;

        request.setCharacterEncoding("UTF-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        sfu.setFileSizeMax(10 * 1024 * 1024);

        try {
            List<FileItem> items = sfu.parseRequest(request);

            for (FileItem item : items){
                if (!item.isFormField()){
                    ServletContext servletContext = request.getServletContext();
                    String path = servletContext.getRealPath("/statics/head_images");

                    String fileName = item.getName();
                    String fileType = fileName.substring(fileName.lastIndexOf("."));

                    System.out.println(path + "/" + userId + fileType);

                    File file = new File(path + "/" + userId + fileType);
                    item.write(file);

                    Map<String, Object> fieldMap = new HashMap<String, Object>();
                    fieldMap.put("head_image", "/statics/head_images/" + file.getName());
                    //UserService.getInstance().updateUser(userId, fieldMap);

                    result = true;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }
}
