package io.walkers.planes.pandora.spring.custom.core;

/**
 * 自定义的 Bean 初始化前后处理器
 *
 * @author planeswalker23
 */
public interface CustomBeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
