package test.hjd.com.testapp.download.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import test.hjd.com.testapp.download.IDownloadService;

/**
 * Created by allen on 2022-06-30.
 *
 * Download monitor
 */
public class DownloadProxy {
    private IDownloadService downloadService;

    public DownloadProxy(IDownloadService downloadService) {
        this.downloadService = downloadService;
    }

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxyObject);

        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }


    private class DynamicProxyHandler implements InvocationHandler{
        private Object proxyObject;

        public DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //todo moitor
            Object result = method.invoke(proxyObject, args);

            return result;
        }
    }
}
