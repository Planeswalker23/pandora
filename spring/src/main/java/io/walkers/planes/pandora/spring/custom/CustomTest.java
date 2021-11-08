package io.walkers.planes.pandora.spring.custom;

import io.walkers.planes.pandora.spring.custom.core.CustomApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * 自定义 Spring 容器测试类
 *
 * @author planeswalker23
 */
public class CustomTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CustomApplicationContext customApplicationContext = new CustomApplicationContext(CustomConfig.class);
        Object userService = customApplicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(customApplicationContext.getBean("userService"));
        System.out.println(customApplicationContext.getBean("userService"));
    }
}
