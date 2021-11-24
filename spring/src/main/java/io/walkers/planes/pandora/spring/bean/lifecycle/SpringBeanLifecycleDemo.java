package io.walkers.planes.pandora.spring.bean.lifecycle;

import io.walkers.planes.pandora.spring.bean.lifecycle.postprocessor.CustomDestructionAwareBeanPostProcessor;
import io.walkers.planes.pandora.spring.bean.lifecycle.postprocessor.CustomInstantiationAwareBeanPostProcessor;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Bean 生命周期示例
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class SpringBeanLifecycleDemo {

    @Test
    public void lifecycle() throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 BeanPostProcessor
        applicationContext.getBeanFactory().addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());
        applicationContext.getBeanFactory().addBeanPostProcessor(new CustomDestructionAwareBeanPostProcessor());

        // 注册 BeanDefinition
        // 使用 @Bean 声明 User 对象时 CustomInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation 未生效
        BeanDefinitionBuilder userBeanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        userBeanDefinitionBuilder.addPropertyValue("name", "生命周期");
        // 初始化阶段：指定自定义初始化方法
        userBeanDefinitionBuilder.setInitMethodName("initMethod");
        userBeanDefinitionBuilder.setDestroyMethodName("destroyMethod");
        applicationContext.registerBeanDefinition("user", userBeanDefinitionBuilder.getBeanDefinition());

        applicationContext.register(SpringBeanLifecycleDemo.class);
        System.out.println("Spring 容器准备启动");
        applicationContext.refresh();
        System.out.println("Spring 容器启动完成");

        User user = applicationContext.getBean(User.class);

        System.out.println("依赖查询 User 类型对象结果：" + user);

        // 为什么此处没有触发自定义销毁方法
        // org.springframework.beans.factory.config.AutowireCapableBeanFactory.destroyBean 在创建 DisposableBeanAdapter 对象时不会基于 RootBeanDefinition 指定自定义销毁方法
        System.out.println("开始基于 AutowireCapableBeanFactory#destroyBean(Object existingBean) 触发 User 对象的销毁生命周期");
        applicationContext.getBeanFactory().destroyBean(user);
        System.out.println("基于 AutowireCapableBeanFactory#destroyBean(Object existingBean) 触发 User 对象的销毁生命周期完成");
        // org.springframework.beans.factory.config.ConfigurableBeanFactory.destroyBean 在创建 DisposableBeanAdapter 对象时会基于 RootBeanDefinition 指定自定义销毁方法
        System.out.println("开始基于 ConfigurableBeanFactory#destroyBean(String beanName, Object beanInstance) 触发 User 对象的销毁生命周期");
        applicationContext.getBeanFactory().destroyBean("user", user);
        System.out.println("基于 ConfigurableBeanFactory#destroyBean(String beanName, Object beanInstance) 触发 User 对象的销毁生命周期完成");

        System.out.println("Spring 容器准备关闭");
        applicationContext.close();
        System.out.println("Spring 容器关闭完成");

        user = null;
        // 强制触发 GC
        System.gc();
        Thread.sleep(1000L);
    }


}
