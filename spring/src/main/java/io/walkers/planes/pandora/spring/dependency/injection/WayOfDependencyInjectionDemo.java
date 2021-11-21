package io.walkers.planes.pandora.spring.dependency.injection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 依赖注入方式示例
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
public class WayOfDependencyInjectionDemo {

    // 构造器注入
    @Bean(name = "constructor")
    public WayOfDIUser userConstructor() {
        return new WayOfDIUser("构造器注入");
    }

    @Test
    public void constructor() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WayOfDependencyInjectionDemo.class);
        WayOfDIUser user = applicationContext.getBean("constructor", WayOfDIUser.class);
        System.out.println("构造器注入: " + user);
    }

    // setter注入
    @Bean(name = "setter")
    public WayOfDIUser userSetter() {
        return new WayOfDIUser("setter 注入");
    }

    @Test
    public void setter() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WayOfDependencyInjectionDemo.class);
        WayOfDIUser user = applicationContext.getBean("setter", WayOfDIUser.class);
        System.out.println("setter注入: " + user);
    }

    // 字段注入
    @Autowired
    @Qualifier("field")
    private WayOfDIUser user;

    @Bean(name = "field")
    public WayOfDIUser userField() {
        return new WayOfDIUser("字段注入");
    }

    @Test
    public void field() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WayOfDependencyInjectionDemo.class);
        WayOfDependencyInjectionDemo bean = applicationContext.getBean(WayOfDependencyInjectionDemo.class);
        System.out.println("字段注入: " + bean.user);
    }

    // 方法注入
    @Bean(name = "method")
    public WayOfDIUser userMethod() {
        return new WayOfDIUser("方法注入");
    }

    private WayOfDIUser method;

    @Autowired
    public void init(WayOfDIUser method) {
        this.method = method;
    }

    @Test
    public void method() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WayOfDependencyInjectionDemo.class);
        WayOfDependencyInjectionDemo bean = applicationContext.getBean(WayOfDependencyInjectionDemo.class);
        System.out.println("方法注入: " + bean.method);
    }
}
