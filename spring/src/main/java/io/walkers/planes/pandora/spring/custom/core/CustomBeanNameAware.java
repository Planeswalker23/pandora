package io.walkers.planes.pandora.spring.custom.core;

/**
 * 自定义的 BeanNameAware 回调接口
 *
 * @author planeswalker23
 * @date 2021/11/9
 */
public interface CustomBeanNameAware {

    void setBeanName(String name);
}
