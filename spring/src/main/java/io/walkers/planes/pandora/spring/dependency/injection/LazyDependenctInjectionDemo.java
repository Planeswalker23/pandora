package io.walkers.planes.pandora.spring.dependency.injection;

import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 基于 {@link ObjectProvider} 注解进行延迟注入(主要用于注入非必要依赖)
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
@Configuration
public class LazyDependenctInjectionDemo {

    // 实时注入
    @Autowired
    private User user;
    // 延迟注入
    @Autowired
    private ObjectProvider<User> userObjectProvider;
    // 延迟注入集合类型
    @Autowired
    private ObjectProvider<List<User>> listObjectProvider;

    @Test
    public void qualifier() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(LazyDependenctInjectionDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        System.out.println("容器启动完成");
        LazyDependenctInjectionDemo bean = applicationContext.getBean(LazyDependenctInjectionDemo.class);
        System.out.println("实时注入 user = " + bean.user);
        System.out.println("延迟注入 userObjectProvider = " + bean.userObjectProvider.getObject());
        System.out.println("延迟注入集合类型 listObjectProvider = " + bean.listObjectProvider.getObject());

        applicationContext.close();

    }

    @Bean
    @Primary
    public User user() {
        return new User("user");
    }

    @Bean
    public User user2() {
        return new User("user2");
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
