package io.walkers.planes.pandora.spring.custom.core;

/**
 * 自定义的 InitializingBean 初始化接口
 *
 * @author planeswalker23
 * @date 2021/11/9
 */
public interface CustomInitializingBean {
    
    void afterPropertiesSet();
}
