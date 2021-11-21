package io.walkers.planes.pandora.spring.dependency.source;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源示例
 * 1. Spring BeanDefinition，Spring 可管理其生命周期，可用于依赖注入和依赖查找
 * 2. 单体对象，外部已初始化完成的对象，可用于依赖注入和依赖查找
 * 3. 非 Spring 管理对象(ResolvableDependency)，可用于依赖注入
 * 4. 非常规 Spring 对象(外部化配置/配置文件)作为依赖来源
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
public class DependencySourceDemo {

    // 注入在 postProcessProperties 方法执行时，早于 setter 注入，也早于 @PostConstructor
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 容器启动时会初始化 BeanFactory
     * 依赖注入的来源比依赖查找会多一项(保存非 Spring 管理对象，如 BeanFactory)
     *
     * @see AbstractApplicationContext#prepareBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
     */
    @PostConstruct
    public void initByInjection() {
        // false
        System.out.println("beanFactory == applicationContext " + (beanFactory == applicationContext));
        // 都是 true
        System.out.println("beanFactory == applicationContext.getBeanFactory() " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext " + (resourceLoader == applicationContext));
        System.out.println("ApplicationEventPublisher == applicationContext " + (applicationEventPublisher == applicationContext));
    }

    // 依赖查找非 Spring 管理对象会找不到
    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    private <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("当前类型" + beanType.getName() + " 无法在 BeanFactory 中查找!");
        }
        return null;
    }

    @Test
    public void demo() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencySourceDemo.class);
        DependencySourceDemo bean = applicationContext.getBean(DependencySourceDemo.class);
    }
}
