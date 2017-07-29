package top.pengcheng789.java.penblog.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.pengcheng789.java.penblog.annotation.Aspect;
import top.pengcheng789.java.penblog.annotation.Controller;
import top.pengcheng789.java.penblog.proxy.AspectProxy;
import top.pengcheng789.java.penblog.proxy.CheckFormProxy;
import top.pengcheng789.java.penblog.proxy.Proxy;
import top.pengcheng789.java.penblog.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * 方法拦截助手类
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public final class AopHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);

    static {
        try {
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);

            for (Map.Entry<Class<?>, List<Proxy>> entry : targetMap.entrySet()) {
                Class<?> targetClass = entry.getKey();
                List<Proxy> proxyList = entry.getValue();

                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass, proxy);
            }
        } catch (Exception e) {
            LOGGER.error("aop failure", e);
        }
    }

    /**
     * 获取需要代理的目标类集合
     *
     * @param aspect
     * @return
     * @throws Exception
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
        Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
        Class<? extends Annotation> annotation = aspect.value();

        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }

        return targetClassSet;
    }

    /**
     * 获取代理类与其目标类集合之间的关系
     *
     * @return
     * @throws Exception
     */
    private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();

        addAspectProxy(proxyMap);
        addCheckFormProxy(proxyMap);

        return proxyMap;
    }

    /**
     * 获取目标类与代理对象列表之间的映射关系
     */
    private static Map<Class<?>, List<Proxy>> createTargetMap(
            Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();

        for (Map.Entry<Class<?>, Set<Class<?>>> entry : proxyMap.entrySet()) {
            Class<?> proxyClass = entry.getKey();
            Set<Class<?>> targetClassSet = entry.getValue();

            for (Class<?> targetClass : targetClassSet) {
                Proxy proxy = (Proxy)proxyClass.newInstance();

                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = new ArrayList<Proxy>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }

        return targetMap;
    }

    private static void addAspectProxy(
            Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);

        for (Class<?> proxyClass : proxyClassSet) {
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass, targetClassSet);
            }
        }
    }

    private static void addCheckFormProxy (Map<Class<?>, Set<Class<?>>> proxyMap)
        throws Exception {
        Set<Class<?>> controllerClassSet = ClassHelper
                .getClassSetByAnnotation(Controller.class);

        proxyMap.put(CheckFormProxy.class, controllerClassSet);
    }
}
