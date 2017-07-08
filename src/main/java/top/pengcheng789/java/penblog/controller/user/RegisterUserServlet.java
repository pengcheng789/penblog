package top.pengcheng789.java.penblog.controller.user;

import top.pengcheng789.java.penblog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by pen on 17-7-3.
 */
@WebServlet("/user/register")
@MultipartConfig
public class RegisterUserServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/views/user/registering.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        /**
         * 判断两次密码输入是否一样
         */
        if (!request.getParameter("password")
                .equals(request.getParameter("confirm_password"))){
            String error = "两次输入的密码不一样！";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/views/user/registering.jsp")
                    .forward(request, response);
        }

        /**
         * 判断邮箱是否已被使用
         */
        if (UserService.getInstance().isMailExist(request.getParameter("mail"))){
            String error = "邮箱已被使用！";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/views/user/registering.jsp")
                    .forward(request, response);
        }

        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("id", UUID.randomUUID().toString());
        fieldMap.put("mail", request.getParameter("mail"));
        fieldMap.put("nickname", request.getParameter("nickname"));
        fieldMap.put("password", request.getParameter("password"));
        fieldMap.put("sex", request.getParameter("sex"));
        fieldMap.put("create_date", new Date());

        UserService.getInstance().createUser(fieldMap);
//        request.getRequestDispatcher("/WEB-INF/views/admin/user.jsp")
//                .forward(request, response);
        response.sendRedirect("/penblog/admin/user");
    }
}
