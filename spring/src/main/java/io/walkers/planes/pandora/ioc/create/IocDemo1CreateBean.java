package io.walkers.planes.pandora.ioc.create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
