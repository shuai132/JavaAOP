package nodep.proxy;

import nodep.proxy.annotation.CountTime;
import nodep.proxy.annotation.Safe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class AopProxy extends ProxyBase {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = null;
        if (isAnnotationPresent(method, Safe.class)) {
            // 安全方法（catch任何异常）
            try {
                ret = method.invoke(target, args);
            } catch (Exception e) {
                System.out.println("go wrong! but I'm fine~");
            }
        }
        else if (isAnnotationPresent(method, CountTime.class)) {
            // 需要计时的方法
            long start = System.currentTimeMillis();
            ret = method.invoke(target, args);
            long end = System.currentTimeMillis();
            System.out.println("函数(" + method.getName() + ")执行耗时 : " + (end - start) + "毫秒 ");
        }
        else {
             // 正常调用
             ret = method.invoke(target, args);
        }
        after();
        return ret;
    }

    // 判断被代理类target实现的method是否包含指定注解
    private boolean isAnnotationPresent(Method method, Class<? extends Annotation> annotationClass) throws Throwable {
        return target.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(annotationClass);
    }

    private void before() {
        System.out.println("函数执行前");
    }

    private void after() {
        System.out.println("函数执行后");
    }
}
