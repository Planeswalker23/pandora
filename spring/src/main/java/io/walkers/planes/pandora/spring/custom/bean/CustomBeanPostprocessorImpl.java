package io.walkers.planes.pandora.spring.custom.bean;

import io.walkers.planes.pandora.spring.custom.core.CustomBeanPostProcessor;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomComponent;

/**
 * CustomBeanPostProcessor 实现类
 *
 * @author planeswalker23
 */
@CustomComponent(value = "customBeanPostprocessorImpl")
public class CustomBeanPostprocessorImpl implements CustomBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("[DEBUG MESSAGE] Bean " + beanName + " 初始化前的处理");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("[DEBUG MESSAGE] Bean " + beanName + " 初始化后的处理");
        return bean;
    }
}
