package ioc;

import ioc.bean.Customer;
import ioc.bean.User;
import ioc.bean.UserCollection;
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
    public void injectBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        User user = applicationContext.getBean("injectBySetter", User.class);
        System.out.println("setter 方式注入属性：" + user);
    }

    @Test
    public void injectByConstructor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        User user = applicationContext.getBean("injectByConstructor", User.class);
        System.out.println("有参构造器方式注入属性：" + user);
    }

    @Test
    public void injectSpecialField() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        User user = applicationContext.getBean("injectSpecialField", User.class);
        System.out.println("注入空值/特殊符号属性：" + user);
    }

    @Test
    public void injectOuterBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        Customer customer = applicationContext.getBean("injectOuterBean", Customer.class);
        System.out.println("注入外部 Bean：" + customer);
    }

    @Test
    public void injectInnerBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        Customer customer = applicationContext.getBean("injectInnerBean", Customer.class);
        System.out.println("注入内部 Bean：" + customer);
    }

    @Test
    public void injectByCascade() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        Customer customer = applicationContext.getBean("injectByCascade", Customer.class);
        System.out.println("通过级联赋值注入属性：" + customer);
    }

    @Test
    public void injectCollection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo1-create-bean.xml");
        UserCollection userCollection = applicationContext.getBean("injectCollection", UserCollection.class);
        System.out.println("注入集合类型：" + userCollection);
    }
}
