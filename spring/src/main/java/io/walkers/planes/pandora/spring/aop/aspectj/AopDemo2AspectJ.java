package io.walkers.planes.pandora.spring.aop.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author planeswalker23
 * @date 2021/11/7
 */
public class AopDemo2AspectJ {

    @Test
    public void before() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/aop-demo1-aspectj.xml");
        LoginService loginService = applicationContext.getBean("loginService", LoginService.class);
        loginService.doSomething();
    }

    @Test(expected = RuntimeException.class)
    public void exception() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/aop-demo1-aspectj.xml");
        LoginService loginService = applicationContext.getBean("loginService", LoginService.class);
        loginService.doSomethingThrowException();
    }
}
