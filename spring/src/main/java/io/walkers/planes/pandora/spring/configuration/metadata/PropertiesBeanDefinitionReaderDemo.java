package io.walkers.planes.pandora.spring.configuration.metadata;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

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

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("configuration.metadata/user.properties");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        int definitions = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("加载 BeanDefinition 数量 = " + definitions);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
        // properties 配置文件的默认生成 Bean name 的策略：[.(class)]前面的即为 Bean name
        User customBean = beanFactory.getBean("customBean", User.class);
        System.out.println(customBean);
    }
}
