package io.walkers.planes.pandora.spring.bean.definition;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link BeanDefinition} 创建示例
 *
 * @author planeswalker23
 * @date 2021/11/16
 */
public class BeanDefinitionCreationDemo {

    @Test
    public void createBeanDefinitionByBeanDefinitionBuilder() {
        // 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置属性值
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "planeswalker23");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 生成的 BeanDefinition 并非终态，还可以进行属性设置
        beanDefinition.setBeanClassName("modifyUser");
    }

    @Test
    public void createBeanDefinitionByAbstractBeanDefinition() {
        // 通过 AbstractBeanDefinition 及派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 设置属性值
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id", 1)
                .add("name", "planeswalker23");
        mutablePropertyValues.addPropertyValue("name", "planeswalker23");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = genericBeanDefinition.getOriginatingBeanDefinition();
        // 生成的 BeanDefinition 并非终态，还可以进行属性设置
        beanDefinition.setBeanClassName("modifyUser");
    }
}
