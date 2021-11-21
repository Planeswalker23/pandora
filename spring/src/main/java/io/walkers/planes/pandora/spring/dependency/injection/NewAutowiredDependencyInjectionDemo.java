package io.walkers.planes.pandora.spring.dependency.injection;

import io.walkers.planes.pandora.spring.dependency.injection.annotation.NewAutowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 使用自定义的注解 {@link NewAutowired} 进行依赖注入
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
@Configuration
public class NewAutowiredDependencyInjectionDemo {

    @Autowired
    private User user;
    @NewAutowired
    private User newUser;

    // 将 Bean name 修改为 AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME
    // 同时 AutowiredAnnotationBeanPostProcessor 设置为静态 static 类型
    //     （改为 static 这是由于本类 NewAutowiredDependencyInjectionDemo 的实例化早于当前 AutowiredAnnotationBeanPostProcessor 类型的 Bean 导致的，
    //      故需要将 AutowiredAnnotationBeanPostProcessor 类型的 Bean 提前实例化）
    @Bean(name = AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static AutowiredAnnotationBeanPostProcessor commonAutowiredAnnotationBeanPostProcessor() {
        System.out.println("NewAutowired AutowiredAnnotationBeanPostProcessor");
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        // 使用新注解进行处理
        beanPostProcessor.setAutowiredAnnotationType(NewAutowired.class);
        return beanPostProcessor;
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public static AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
        System.out.println("Autowired AutowiredAnnotationBeanPostProcessor");
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        // 使用 Spring 提供的注解进行处理
        beanPostProcessor.setAutowiredAnnotationType(Autowired.class);
        return beanPostProcessor;
    }

    @Test
    public void qualifier() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NewAutowiredDependencyInjectionDemo.class);
        NewAutowiredDependencyInjectionDemo bean = applicationContext.getBean(NewAutowiredDependencyInjectionDemo.class);
        System.out.println("user = " + bean.user);
        System.out.println("newUser = " + bean.newUser);

    }

    @Bean
    public User user1() {
        return new User("user1");
    }

    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
