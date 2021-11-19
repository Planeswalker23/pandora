package io.walkers.planes.pandora.spring.dependency.lookup;

import org.junit.Test;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 依赖查找异常示例
 *
 * @author planeswalker23
 * @date 2021/11/19
 */
public class ExceptionOfDependencyLookupDemo {

    /**
     * @see BeanCreationException
     */
    @Test(expected = BeanCreationException.class)
    public void beanCreationException() {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 BeanDefinition Bean Class 是一个 POJO 普通类，不过初始化方法回调时抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

        // 启动应用上下文
        applicationContext.refresh();

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * @see BeanInstantiationException
     */
    @Test(expected = BeanCreationException.class)
    public void beanInstantiationException() {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 BeanDefinition Bean Class 是一个接口
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BeanFactory.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

        // 启动应用上下文
        applicationContext.refresh();

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * @see NoUniqueBeanDefinitionException
     */
    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void noUniqueBeanDefinitionException() {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 String 类型的 Bean
        applicationContext.registerBean("string1", String.class);
        applicationContext.registerBean("string2", String.class);

        // 启动应用上下文
        applicationContext.refresh();

        String bean = applicationContext.getBean(String.class);
        System.out.println(bean);

        // 关闭应用上下文
        applicationContext.close();
    }

    public static class User {

        @PostConstruct // CommonAnnotationBeanPostProcessor
        public void init() throws Throwable {
            throw new Throwable("init() : For purposes...");
        }
    }
}
