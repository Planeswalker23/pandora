package io.walkers.planes.pandora.spring.bean.factory;

import io.walkers.planes.pandora.spring.bean.definition.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 用户类工厂
 *
 * @author planeswalker23
 */
public class UserFactory implements InitializingBean, DisposableBean {

    public User createUserByUserFactory() {
        return User.createUser();
    }

    // ---------- Bean 初始化 ----------
    // 1. 构造器后置的初始化方法
    @PostConstruct
    public void postConstruct() {
        System.out.println("1. @PostConstruct 初始化方法");
    }

    // 2. 属性填充后的初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2. InitializingBean#afterPropertiesSet 初始化方法");

    }

    // 3. 自定义初始化方法
    public void customInitializationMethod() {
        System.out.println("3. 自定义的初始化方法");
    }

    // ---------- Bean 销毁 ----------
    // 1. @PreDestroy 销毁方法
    @PreDestroy
    public void preDestroy() {
        System.out.println("1. @PreDestroy 销毁方法");
    }

    // 2. DisposableBean#destroy 销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("2. DisposableBean#destroy 销毁方法");
    }

    // 3. 自定义销毁方法
    public void customDestroyMethod() {
        System.out.println("3. 自定义的销毁方法");
    }
}
