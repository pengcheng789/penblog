package top.pengcheng789.java.penblog.controller.user;

import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pen on 17-7-8.
 */
@WebServlet("/user/delete/*")
public class DeleteUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String pathInfo = request.getPathInfo();
        String id = pathInfo.substring(1, pathInfo.length());

        boolean result = UserService.getInstance().deleteUser(id);

        List<User> users = UserService.getInstance().getUsers();

        request.setAttribute("id", id);
        request.setAttribute("result", result);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/views/admin/list.jsp")
                .forward(request, response);
    }
}
