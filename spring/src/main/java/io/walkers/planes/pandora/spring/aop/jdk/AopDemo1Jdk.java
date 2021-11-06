package io.walkers.planes.pandora.spring.aop.jdk;

import java.lang.reflect.Proxy;

/**
 * jdk 实现动态代理：创建接口实现类代理对象，增强类的方法
 *
 * a）连接点：类里面哪些方法可以被增强，这些方法称为连接点（如 LoginService 接口中的所有方法）
 * b）切入点：实际被真正增强的方法称为切入点（如 LoginService 接口中被增强的 login 方法）
 * c）通知（增强）：实际增强的逻辑部分称为通知，且分为以下五种类型：（如 LoginServiceProxy 类 invoke 方法中的前置后置操作）
 *  1）前置通知
 *  2）后置通知
 *  3）环绕通知
 *  4）异常通知
 *  5）最终通知
 * d）切面：把通知应用到切入点过程
 *
 * @author planeswalker23
 * @date 2021/11/6
 */
public class AopDemo1Jdk {

    public static void main(String[] args) {
        Class[] interfaces = {LoginService.class};
        LoginServiceImpl loginService = new LoginServiceImpl();
        LoginService proxy = (LoginService) Proxy.newProxyInstance(LoginServiceProxy.class.getClassLoader(), interfaces, new LoginServiceProxy(loginService));
        proxy.login("1");
    }
}
