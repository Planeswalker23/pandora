package io.walkers.planes.pandora.spring.custom;

import io.walkers.planes.pandora.spring.custom.bean.UserService;
import io.walkers.planes.pandora.spring.custom.core.CustomApplicationContext;
import org.junit.Test;

/**
 * 自定义 Spring 容器测试类
 *
 * @author planeswalker23
 */
public class CustomTest {

    @Test
    public void testScope() {
        CustomApplicationContext customApplicationContext = new CustomApplicationContext(CustomConfig.class);
        Object userService = customApplicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(customApplicationContext.getBean("userService"));
        System.out.println(customApplicationContext.getBean("userService"));
    }

    @Test
    public void testAutowired() {
        CustomApplicationContext customApplicationContext = new CustomApplicationContext(CustomConfig.class);
        UserService userService = (UserService) customApplicationContext.getBean("userService");
        userService.add();
    }
}
