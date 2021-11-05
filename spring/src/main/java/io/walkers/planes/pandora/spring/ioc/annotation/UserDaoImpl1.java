package io.walkers.planes.pandora.spring.ioc.annotation;

import org.springframework.stereotype.Repository;

/**
 * @author planeswalker23
 * @date 2021/11/4
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl1 implements UserDao {

    @Override
    public void daoMethod() {
        System.out.println("UserDaoImpl1#daoMethod");
    }
}
