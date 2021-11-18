package io.walkers.planes.pandora.spring.bean.factory;

import io.walkers.planes.pandora.spring.bean.definition.User;

/**
 * 用户类工厂
 *
 * @author planeswalker23
 */
public class UserFactory {

    public User createUserByUserFactory() {
        return User.createUser();
    }
}
