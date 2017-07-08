package top.pengcheng789.java.penblog.controller.admin;

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
 * Created by pen on 17-7-6.
 */

@WebServlet("/admin/user")
public class ManageUserServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<User> users = UserService.getInstance().getUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/views/admin/user.jsp")
                .forward(request, response);
    }
}
