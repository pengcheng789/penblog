package top.pengcheng789.java.penblog.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 助手类
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public final class ServletHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);

    /**
     * ServletHelper 池
     */
    private static final ThreadLocal<ServletHelper> SERVLET_HELPER_HOLDER
            = new ThreadLocal<ServletHelper>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    private ServletHelper(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 初始化
     */
    public static void init(HttpServletRequest request, HttpServletResponse response) {
        SERVLET_HELPER_HOLDER.set(new ServletHelper(request, response));
    }

    /**
     * 销毁
     */
    public static void destory() {
        SERVLET_HELPER_HOLDER.remove();
    }

    /**
     * 获取 Request 对象
     */
    public static HttpServletRequest getRequest() {
        return SERVLET_HELPER_HOLDER.get().request;
    }

    /**
     * 获取 Response 对象
     */
    public static HttpServletResponse getResponse() {
        return SERVLET_HELPER_HOLDER.get().response;
    }

    /**
     * 获取 ServletContext 对象
     */
    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }
}
