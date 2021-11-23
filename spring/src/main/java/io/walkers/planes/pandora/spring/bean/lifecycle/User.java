package io.walkers.planes.pandora.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author planeswalker23
 * @date 2021/11/22
 */
public class User implements InitializingBean, SmartInitializingSingleton, DisposableBean {

    private String name;

    public User(String name) {
        this.name = name;
        System.out.println("User 对象正在实例化");
    }

    public User() {
        System.out.println("User 对象正在基于无参构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println("User 对象初始化阶段(1. @PostConstruct)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("User 对象初始化阶段(2. InitializingBean#afterPropertiesSet)");
    }

    public void initMethod() {
        System.out.println("User 对象初始化阶段(3. 自定义初始化方法initMethod)");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("User 对象初始化完成阶段");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("User 对象销毁阶段(1. @PreDestroy)");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("User 对象销毁阶段(2. DisposableBean#destroy)");
    }

    public void destroyMethod() {
        System.out.println("User 对象销毁阶段(3. 自定义销毁方法destroyMethod)");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 User 对象正在被垃圾回收");
        super.finalize();
    }
}
