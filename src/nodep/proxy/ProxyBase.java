package nodep.proxy;

import nodep.proxy.annotation.ProxyClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public abstract class ProxyBase implements InvocationHandler{
    protected Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object newProxyInstance(Object origin) {
        setTarget(origin);
        return newProxyInstance(this);
    }

    private Object newProxyInstance(InvocationHandler invocationHandler) {
        ProxyClass proxyClass = invocationHandler.getClass().getAnnotation(ProxyClass.class);
        Class<?> cls = proxyClass.value();
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), cls.getInterfaces(), invocationHandler);
    }

}
