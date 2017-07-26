package top.pengcheng789.java.penblog.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理链
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxtIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod,
                      MethodProxy methodProxy, Object[] methodParams,
                      List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object doProxyChain() throws Throwable {
        Object methodResult;

        if (proxtIndex < proxyList.size()) {
            methodResult = proxyList.get(proxtIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetObject, methodParams);
        }

        return methodResult;
    }
}
