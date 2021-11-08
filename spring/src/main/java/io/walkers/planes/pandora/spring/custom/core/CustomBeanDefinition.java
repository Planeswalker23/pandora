package io.walkers.planes.pandora.spring.custom.core;

/**
 * 自定义的 Bean 定义类
 *
 * @author planeswalker23
 */
public class CustomBeanDefinition {

    private Class clazz;
    private String beanName;
    private BeanScope scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanScope getScope() {
        return scope;
    }

    public void setScope(BeanScope scope) {
        this.scope = scope;
    }
}
