package nodep.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public abstract class ProxyBase implements InvocationHandler{

    protected Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public <T> T newProxyInstance(T target) {
        setTarget(target);
        return (T)newProxyInstance(this);
    }

    private Object newProxyInstance(InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }

}
