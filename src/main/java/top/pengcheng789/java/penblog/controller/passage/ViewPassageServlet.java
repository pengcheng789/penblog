package top.pengcheng789.java.penblog.controller.passage;

import top.pengcheng789.java.penblog.model.PassageCategory;
import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.PassageService;
import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pen on 17-7-19.
 */
@WebServlet("/passage/list/*")
public class ViewPassageServlet extends HttpServlet {
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

        List<PassageCategory> categories =
                PassageService.getInstance().getCategories();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/WEB-INF/views/passage/admin/passage.jsp")
                .forward(request, response);
    }
}
