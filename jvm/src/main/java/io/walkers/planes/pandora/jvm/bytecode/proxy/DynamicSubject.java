package io.walkers.planes.pandora.jvm.bytecode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理示例
 *
 * 在动态生成的代理类中，会有 equals、toString、hashCode 这三个方法以及被代理类实现接口的方法
 * 它们实际上是调用了实现 InvocationHandler 接口的动态代理类的 invoke 方法，在不改变原来方法的情况下，动态给方法增加功能
 *
 * @author Planeswalker23
 * @date Created in 2020/5/22
 */
public class DynamicSubject implements InvocationHandler {

    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");

        Object result = method.invoke(obj, args);

        System.out.println("after");
        return result;
    }


    public static void main(String[] args) {

        // 保存代理类到 com/sun/proxy/$Proxy0.class
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        ReadSubject rs = new ReadSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(rs);

        Class<?> clazz = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), dynamicSubject);
        subject.dothing();

        System.out.println(subject.toString());
        System.out.println(subject.getClass());

    }
}
