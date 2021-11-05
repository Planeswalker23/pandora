package io.walkers.planes.pandora.ioc.factorybean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FactoryBean: 在配置文件定义 bean 类型可以和返回类型不一样
 *
 * @author planeswalker23
 * @see org.springframework.beans.factory.FactoryBean
 */
public class IocDemo3FactoryBean {

    @Test
    public void injectBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo3-factory-bean.xml");
        User user = applicationContext.getBean("userFactoryBean", User.class);
        System.out.println("FactoryBean：" + user);
    }
}
