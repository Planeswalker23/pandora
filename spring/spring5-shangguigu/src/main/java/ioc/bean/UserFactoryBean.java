package ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂 Bean：在配置文件定义 bean 类型可以和返回类型不一样
 *
 * @author planeswalker23
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() {
        User user = new User("FactoryBeanUser", 20);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
