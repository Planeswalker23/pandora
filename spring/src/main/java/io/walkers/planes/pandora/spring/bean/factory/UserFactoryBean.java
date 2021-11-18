package io.walkers.planes.pandora.spring.bean.factory;

import io.walkers.planes.pandora.spring.bean.definition.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 用户类工厂 Bean
 *
 * @author planeswalker23
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
