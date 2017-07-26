package top.pengcheng789.java.penblog.proxy;

/**
 * 代理接口
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
