package top.pengcheng789.java.penblog.controller.user;

import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pen on 17-7-9.
 */

@WebServlet("/user/edit/name/*")
public class EditUserNameServlet extends HttpServlet {
    @Override
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

        request.setCharacterEncoding("UTF-8");

        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("nickname", request.getParameter("nickname"));
        UserService.getInstance().updateUser(id, fieldMap);

        response.sendRedirect("/penblog/user/profile/" + id);
    }
}
