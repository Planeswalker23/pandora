package io.walkers.planes.pandora.spring.dependency.lookup;

import io.walkers.planes.pandora.spring.bean.definition.User;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 通过 {@link ObjectProvider} 进行延迟依赖查找
 * <p>
 * 应用场景？<br>
 * 如 redis 配置类中非必须参数的设置可以使用延迟依赖查找
 * </p>
 * <p>
 * 与 FactoryBean, ObjectFactory, ObjectProvider 的区别？<br>
 * 两者都可应用于延迟依赖查找 ，ObjectProvider 继承于 ObjectFactory，提供了更高级 Java 语法的特性，例如 Stream, 函数式接口(ObjectProvider#getIfAvailable(java.util.function.Supplier))
 * </p>
 *
 * @author planeswalker23
 * @date 2021/11/18
 * @see FactoryBean
 * @see ObjectFactory
 * @see ObjectProvider
 */
public class ObjectProviderDemo {

    @Test
    public void objectProviderDemo() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();

        // 通过 ObjectProvider 进行延迟依赖查找 String 类型的对象
        ObjectProvider<String> stringObjectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println("通过 ObjectProvider 进行延迟依赖查找 String 类型的对象: " + stringObjectProvider.getObject());
        // stream 操作
        stringObjectProvider.stream().forEach(System.out::println);

        // 通过 ObjectProvider 进行延迟依赖查找不存在的 User 类型的对象
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        System.out.println("通过 ObjectProvider 进行延迟依赖查找不存在的 User 类型的对象: " + userObjectProvider.getIfAvailable());
        System.out.println("通过 ObjectProvider 进行延迟依赖查找不存在的 User 类型的对象并使用 Supplier 兜底: " + userObjectProvider.getIfAvailable(User::new));

        applicationContext.close();
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "Hello, World.";
    }

    @Bean
    public String message() {
        return "Message.";
    }
}
