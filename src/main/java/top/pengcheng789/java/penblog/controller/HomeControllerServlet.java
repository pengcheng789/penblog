package top.pengcheng789.java.penblog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pen on 17-7-3.
 */
@WebServlet({"/", "/home"})
public class HomeControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/views/home/home.jsp")
                .forward(request, response);
    }
}
