package io.walkers.planes.pandora.ioc.scpoe;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean Scope 作用域
 * singleton: 加载 Spring 配置文件时候就会创建单实例对象
 * prototype: 不是在加载 spring 配置文件时候创建对象，而是在调用 getBean 方法时候创建多实例对象
 *
 * @author planeswalker23
 * @see org.springframework.beans.factory.FactoryBean
 */
public class IocDemo5BeanScope {

    @Test
    public void beanScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo4-bean-scope.xml");
        // singleton
        User singletonUser = applicationContext.getBean("singletonUser", User.class);
        User singletonUser2 = applicationContext.getBean("singletonUser", User.class);
        System.out.println(singletonUser);
        System.out.println(singletonUser2);

        // prototype
        User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
        User prototypeUser2 = applicationContext.getBean("prototypeUser", User.class);
        System.out.println(prototypeUser);
        System.out.println(prototypeUser2);
    }
}
