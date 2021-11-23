package io.walkers.planes.pandora.spring.bean.lifecycle;

import io.walkers.planes.pandora.spring.bean.lifecycle.postprocessor.CustomInstantiationAwareBeanPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Spring Bean 生命周期示例
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class SpringBeanLifecycleDemo {

    @Bean
    public User user() {
        return new User("生命周期");
    }

    @Test
    public void lifecycle() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 BeanPostProcessor
        applicationContext.getBeanFactory().addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());

        applicationContext.register(SpringBeanLifecycleDemo.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);

        System.out.println("依赖查询 User 类型对象结果：" + user);
        applicationContext.close();
    }



}
