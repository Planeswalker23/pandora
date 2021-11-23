package io.walkers.planes.pandora.spring.bean.lifecycle.postprocessor;

import io.walkers.planes.pandora.spring.bean.lifecycle.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * Spring Bean 实例化回调后置处理器
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化前置处理：
     * 1. 若返回为 null，则返回默认的实例对象
     * 2. 若返回不为 null，则此对象为最终返回的对象，也就是实例化了一个与配置文件中不同的新的对象
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(beanClass)) {
            System.out.println("User 对象实例化前置处理");
            // 若返回不为 null，则此对象为最终返回的对象，也就是实例化了一个与配置文件中不同的新的对象
//            return new User("实例化前置处理生成的对象");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 实例化后置处理:
     * 1. 若返回为 true, 使用原始 Bean 定义(xml, 注解等)时赋予对象的属性值
     * 2. 若返回为 false, 则会则会忽略原始 Bean 定义时赋予对象的属性值，并使用当前方法中的赋值
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(bean.getClass())) {
            System.out.println("User 对象实例化后置处理");
            // 若返回为 false，则会忽略原始 Bean 定义时赋予对象的属性值，并使用当前方法中的赋值
//            ((User) bean).setName("实例化后置处理");
//            return false;
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 赋值前置处理
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(bean.getClass())) {
            System.out.println("User 对象赋值前置处理开始-----");
            // 原始值
            pvs.stream().forEach(propertyValue -> System.out.println("PropertyValue 对象 key=" + propertyValue.getName() + ", value=" + propertyValue.getValue()));

            // PropertyValues 类不可修改，可转型为 MutablePropertyValues
            // 同时可对转型后的对象进行修改，注入属性用以改变赋值结果
            MutablePropertyValues modifiedPvs = (MutablePropertyValues) pvs;
            modifiedPvs.add("name", "对象赋值前置处理v1");

            // 若返回此 PropertyValues 对象，赋值将使用此对象中的内容
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            mutablePropertyValues.add("name", "对象赋值前置处理v2");
            System.out.println("User 对象赋值前置处理结束-----");
//            return mutablePropertyValues;
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    /**
     * 初始化前置处理
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(bean.getClass())) {
            System.out.println("User 对象初始化前置处理");
            ((User) bean).setName("初始化前置处理");
        }
        // 可返回新的对象
//        return new User();
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化后置处理
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(bean.getClass())) {
            System.out.println("User 对象初始化后置处理");
            ((User) bean).setName("初始化后置处理");
        }
        // 可返回新的对象
//        return new User();
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
