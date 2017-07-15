package top.pengcheng789.java.penblog.controller.user;

import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pen on 17-7-9.
 */
@WebServlet("/user/profile/*")
public class ViewUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String pathInfo = request.getPathInfo();
        String id = pathInfo.substring(1, pathInfo.length());

        User user = UserService.getInstance().getById(id);
        if (user == null){
            response.setStatus(404);
            request.getRequestDispatcher("/WEB-INF/views/common/404.jsp")
                    .forward(request, response);
        }

        request.setAttribute("user", user);
        if(user.getIs_admin() == 0) {
            request.getRequestDispatcher("/WEB-INF/views/user/profile.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/user/profile_admin.jsp")
                    .forward(request, response);
        }
    }
}
