package io.walkers.planes.pandora.spring.dependency.source;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 非 Spring 管理对象，ResolvableDependency 作为依赖来源
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
public class ResolvableDependencyDemo {

    @Autowired
    private String message;

    @PostConstruct
    public void init() {
        System.out.println(message);
    }

    @Test
    public void resolvableDependencyDemo() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencyDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> beanFactory.registerResolvableDependency(String.class, "ResolvableDependency"));

        applicationContext.refresh();
        applicationContext.close();
    }
}
