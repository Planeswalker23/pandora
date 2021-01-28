package io.walkers.planes.pandora.design.patterns.proxy.statical;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author Planeswalker23
 * @date Created in 2020/5/30
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理的类:" + proxy.getClass());
        System.out.println("被代理的类的执行方法:" + method.getName());
        Object object = method.invoke(target, args);
        System.out.println("被代理的类的方法执行完成");
        return object;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Subject subject = new House();
        DynamicProxy dynamicProxy = new DynamicProxy(subject);
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                dynamicProxy);
        proxyInstance.job();
        System.out.println(subject.hashCode());
        System.out.println(proxyInstance.hashCode());
        System.out.println(subject.equals(proxyInstance));

    }
}
