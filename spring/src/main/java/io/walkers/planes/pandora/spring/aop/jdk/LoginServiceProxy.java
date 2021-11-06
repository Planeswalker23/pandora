package io.walkers.planes.pandora.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author planeswalker23
 * @date 2021/11/6
 */
public class LoginServiceProxy implements InvocationHandler {

    private Object obj;

    public LoginServiceProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行方法前的操作
        System.out.println("执行方法前的操作");

        // 执行被增强的方法
        Object result = method.invoke(obj, args);

        // 执行方法后的操作
        System.out.println("执行方法后的操作");

        return result;
    }
}
