package cglib.proxy;

import cglib.proxy.annotation.CountTime;
import cglib.proxy.annotation.Safe;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AopProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object ret = null;

        if(method.isAnnotationPresent(Safe.class)) {
            // 安全方法（catch任何异常）
            try {
                ret = methodProxy.invokeSuper(o, args);
            } catch (Exception e) {
                System.out.println("go wrong! but I'm fine~");
            }
        }
        else if (method.isAnnotationPresent(CountTime.class)) {
            // 需要计时的方法
            long start = System.currentTimeMillis();
            ret = methodProxy.invokeSuper(o, args);
            long end = System.currentTimeMillis();
            System.out.println("函数(" + method.getName() + ")执行耗时 : " + (end - start) + "毫秒 ");
        }
        else {
            // 正常调用
            ret = methodProxy.invokeSuper(o, args);
        }
        after();
        return ret;
    }

    @SuppressWarnings("unchecked")
    public <T> T createEnhancer(Class<T> superclass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(superclass);
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    private void before() {
        System.out.println("函数执行前");
    }

    private void after() {
        System.out.println("函数执行后");
    }
}
