package io.walkers.planes.pandora.spring.configuration.metadata;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * properties 文件生成 BeanDefinition 示例
 *
 * @author planeswalker23
 * @date 2021/11/24
 */
public class PropertiesBeanDefinitionReaderDemo {

    @Test
    public void reader() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        int definitions = beanDefinitionReader.loadBeanDefinitions("configuration.metadata/user.properties");
        System.out.println("加载 BeanDefinition 数量 = " + definitions);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
        // properties 配置文件的默认生成 Bean name 的策略：[.(class)]前面的即为 Bean name
        User customBean = beanFactory.getBean("customBean", User.class);
        System.out.println(customBean);
    }
}
