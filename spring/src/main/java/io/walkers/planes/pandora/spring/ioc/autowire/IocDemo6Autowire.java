package io.walkers.planes.pandora.spring.ioc.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配：根据指定的装配规则（属性名称或属性类型），Spring 自动将匹配的属性值进行注入
 *
 * @author planeswalker23
 */
public class IocDemo6Autowire {

    @Test
    public void autowireByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo6-autowire.xml");
        VipCustomer vipCustomer = applicationContext.getBean("vipCustomer", VipCustomer.class);
        System.out.println(vipCustomer);
    }
}
