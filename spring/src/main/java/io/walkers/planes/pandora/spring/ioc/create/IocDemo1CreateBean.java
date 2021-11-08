package io.walkers.planes.pandora.spring.ioc.create;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 基于 XML 配置文件创建对象
 *
 * @author planeswalker23
 */
public class IocDemo1CreateBean {

    @Test
    public void createBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("基于 XML 配置文件创建对象：" + user);
    }

    @Test
    public void createBean2() {
        // 创建 IOC 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 声明资源
        Resource resource = new ClassPathResource("ioc/ioc-demo1-create-bean.xml");
        // 创建 Bean 读取器，指定资源
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        User user = beanFactory.getBean("user", User.class);
        System.out.println("基于 XML 配置文件创建对象：" + user);
    }
}