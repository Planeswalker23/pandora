package io.walkers.planes.pandora.spring.bean.definition;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化示例
 *
 * @author planeswalker23
 * @date 2021/11/17
 */
public class BeanInstantiationDemo {

    @Test
    public void instantiateBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/bean-instantiation-context.xml");
        User userByStaticMethod = applicationContext.getBean("userByStaticMethod", User.class);
        User userByInstanceMethod = applicationContext.getBean("userByInstanceMethod", User.class);
        User userByFactoryBean = applicationContext.getBean("userByFactoryBean", User.class);
        System.out.println(userByStaticMethod);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
    }
}
