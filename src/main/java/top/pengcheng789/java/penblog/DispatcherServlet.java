package top.pengcheng789.java.penblog;

import top.pengcheng789.java.penblog.bean.*;
import top.pengcheng789.java.penblog.helper.*;
import top.pengcheng789.java.penblog.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 请求转发器
 *
 * CreateDate:2017-07-24
 *
 * @author pen
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化相关 Helper 类
        HelperLoader.init();

        // 获取 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();

        // 注册处理 JSP 的 Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        // 注册处理静态资源的默认 Servlet
        ServletRegistration defaultServlet
                = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求方法与请求路径
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();

        if (requestPath.equals("/favicon.ico")) {
            return;
        }

        // 获取 Action 处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);

        if (handler != null) {
            // 获取 Controller 类及其 Bean 实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            // 创建请求参数
            Param param;
            if (UploadHelper.isMultipart(request)) {
                param = UploadHelper.createParam(request);
            } else {
                param = RequestHelper.createParam(request);
            }

            // 调用 Acton 方法
            Method actionMethod = handler.getActionMethod();
            Object result;
            // 若请求参数为空，则不需要传入参数
            if (param.isEmpty()) {
                result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
            } else {
                result = ReflectionUtil.invokeMethod(controllerBean,
                        actionMethod, param);
            }

            // 处理 Action 方法返回值
            if (result instanceof View) {
                // 返回 JSP 页面
                handleViewResult((View)result, request, response);
            } else if (result instanceof Data) {
                // 返回 JSON 数据
                handleDataResult((Data)result, response);
            }
        } else {
            // 没有匹配的 URL 路径时，返回404页面
            response.setStatus(404);
            request.getRequestDispatcher(ConfigHelper.getAppJspPath() + "common/404.jsp")
                    .forward(request, response);
        }
    }

    /**
     * 处理 View 返回值
     */
    private void handleViewResult(View view, HttpServletRequest request,
                                  HttpServletResponse response)
        throws IOException, ServletException {
        String path = view.getPath();

        if (path.startsWith("/")) {
            response.sendRedirect(request.getContextPath() + path);
        } else {
            Map<String, Object> model = view.getModel();
            for (Map.Entry<String, Object> entry : model.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }

            request.getRequestDispatcher(ConfigHelper.getAppJspPath()
                    + path).forward(request, response);
        }
    }

    /**
     * 处理 Data 返回值
     */
    private void handleDataResult(Data data, HttpServletResponse response)
            throws IOException {
        Object model = data.getModel();

        if (model != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);

            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
