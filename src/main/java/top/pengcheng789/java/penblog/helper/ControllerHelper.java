package top.pengcheng789.java.penblog.helper;

import top.pengcheng789.java.penblog.annotation.Action;
import top.pengcheng789.java.penblog.bean.Handler;
import top.pengcheng789.java.penblog.bean.Request;
import top.pengcheng789.java.penblog.util.ArrayUtil;
import top.pengcheng789.java.penblog.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        // 获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            // 遍历 Controller 类
            for (Class<?> controllerClass : controllerClassSet) {
                // 获取 Controller 类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();

                if (ArrayUtil.isNotEmpty(methods)) {
                    // 遍历这些 Controller 类中的方法
                    for (Method method : methods) {
                        // 判断当前方法是否带有 Action 注解
                        if (method.isAnnotationPresent(Action.class)) {
                            // 从 Action 注解中获取 URL 映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();

                            // 验证 URL 规则
                            if (mapping.matches("\\w+:/[A-Za-z0-9_/]*")) {
                                String[] array = mapping.split(":");

                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    // 获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];

                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 返回请求信息与请求处理器的映射
     */
    public static Map<Request, Handler> getActionMap() {
        return ACTION_MAP;
    }

    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
