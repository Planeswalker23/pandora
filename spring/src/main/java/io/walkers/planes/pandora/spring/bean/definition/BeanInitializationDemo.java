package io.walkers.planes.pandora.spring.bean.definition;

import io.walkers.planes.pandora.spring.bean.factory.UserFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化示例
 *
 * @author planeswalker23
 * @date 2021/11/18
 */
@Configuration
public class BeanInitializationDemo {

    @Test
    public void initializationBean() {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(BeanInitializationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动...");
        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("Spring 应用上下文准备关闭...");
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
    }

    @Bean(initMethod = "customInitializationMethod", destroyMethod = "customDestroyMethod")
    // 延迟初始化: 依赖查找(按需，需要用到它)时才进行 Bean 的初始化
    @Lazy
    public UserFactory userFactory() {
        return new UserFactory();
    }
}
