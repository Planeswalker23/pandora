package io.walkers.planes.pandora.spring.custom.bean;

import io.walkers.planes.pandora.spring.custom.core.CustomBeanNameAware;
import io.walkers.planes.pandora.spring.custom.core.CustomInitializingBean;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomAutowired;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomComponent;

/**
 * 自定义的 Bean
 *
 * @author planeswalker23
 */
//@CustomScope(BeanScope.PROTOTYPE)
@CustomComponent("userService")
public class UserService implements CustomBeanNameAware, CustomInitializingBean {

    @CustomAutowired("orderService")
    private OrderService orderService;

    public void add() {
        System.out.println("Method add has been called. Field OrderService is " + orderService);
    }

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[DEBUG MESSAGE] 初始化接口 CustomInitializingBean#afterPropertiesSet 被调用, OrderService = " + orderService);
        System.out.println("[DEBUG MESSAGE] 初始化接口 CustomInitializingBean#afterPropertiesSet 被调用, beanName = " + beanName);
    }
}
