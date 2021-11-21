package io.walkers.planes.pandora.spring.dependency.injection;

import io.walkers.planes.pandora.spring.dependency.injection.annotation.CustomQualifier;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 基于 {@link Qualifier} 注解进行限定注入（分组）
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
@Configuration
public class QualifierDependencyInjectionDemo {

    @Autowired
//    @CustomAutowired
    private User user;
    @Autowired
    private List<User> allUsers;
    @Autowired
    @Qualifier
    private List<User> qualifierUsers;
    @Autowired
    @CustomQualifier
    private List<User> customQualifierUsers;
    @Autowired
    @Qualifier("custom")
    private List<User> qualifierCustomUsers;

    @Test
    public void qualifier() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifierDependencyInjectionDemo.class);
        QualifierDependencyInjectionDemo bean = applicationContext.getBean(QualifierDependencyInjectionDemo.class);
        System.out.println("user = " + bean.user);
        System.out.println("allUsers = " + bean.allUsers);
        System.out.println("qualifierUsers = " + bean.qualifierUsers);
        System.out.println("customQualifierUsers = " + bean.customQualifierUsers);
        System.out.println("qualifierCustomUsers = " + bean.qualifierCustomUsers);

    }

    @Bean
    @Primary
    public User user1() {
        return new User("user1");
    }

    @Bean
    @Qualifier("custom")
    public User user2() {
        return new User("custom");
    }

    @Bean
    @Qualifier
    public User user3() {
        return new User("user3");
    }

    @Bean
    @CustomQualifier
    public User user4() {
        return new User("user4");
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
