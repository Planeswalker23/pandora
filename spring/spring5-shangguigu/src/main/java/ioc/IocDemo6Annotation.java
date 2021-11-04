package ioc;

import ioc.bean.annotation.UserService;
import ioc.bean.annotation.config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于注解创建对象
 *
 * @author planeswalker23
 */
public class IocDemo6Annotation {

    @Test
    public void annotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo6-annotation.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.method();
    }

    @Test
    public void annotationInjectByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo6-annotation.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.injectByType();
    }

    @Test
    public void annotationInjectByQualifier() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo6-annotation.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.injectByQualifier();
    }

    @Test
    public void annotationInjectByResource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo6-annotation.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.injectByResource();
    }

    @Test
    public void annotationWithoutXml() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.method();
    }
}
