package top.pengcheng789.java.penblog.controller.passage;

import top.pengcheng789.java.penblog.model.PassageCategory;
import top.pengcheng789.java.penblog.service.PassageService;
import top.pengcheng789.java.penblog.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pen on 17-7-19.
 */
@WebServlet("/passage/category/add/*")
public class AddCategoryServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Map<String, Object> filedMap = new HashMap<String, Object>();

        filedMap.put("name", request.getParameter("name"));

        PassageService.getInstance().createCategory(filedMap);

        String pathInfo = request.getPathInfo();
        String id = pathInfo.substring(1, pathInfo.length());

        response.sendRedirect("/penblog/passage/list/" + id);
    }
}
