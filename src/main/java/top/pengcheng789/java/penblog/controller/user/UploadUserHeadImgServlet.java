package top.pengcheng789.java.penblog.controller.user;

import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UploadHeadImgService;
import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pen on 17-7-10.
 */
@WebServlet("/user/upload/head_image/*")
@MultipartConfig
public class UploadUserHeadImgServlet extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String pathInfo = request.getPathInfo();
        String id = pathInfo.substring(1, pathInfo.length());

        User user = UserService.getInstance().getById(id);
        if (user == null){
            response.setStatus(404);
            request.getRequestDispatcher("/WEB-INF/views/common/404.jsp")
                    .forward(request, response);
        }

        boolean result = UploadHeadImgService.getInstance().uploadHeadImg(request, id);

        if (!result){
            response.setStatus(400);
            request.getRequestDispatcher("/WEB-INF/views/common/400.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/penblog/user/profile/" + id);
        }
    }
}
