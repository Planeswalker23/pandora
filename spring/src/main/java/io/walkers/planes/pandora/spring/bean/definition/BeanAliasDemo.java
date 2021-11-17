package io.walkers.planes.pandora.spring.bean.definition;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author planeswalker23
 * @date 2021/11/16
 */
public class BeanAliasDemo {

    @Test
    public void beanAliasDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/bean-alias-context.xml");
        User user = applicationContext.getBean("user", User.class);
        User planeswalker23 = applicationContext.getBean("planeswalker23", User.class);
        System.out.println("user == planeswalker23 : " + (user == planeswalker23));
    }
}
