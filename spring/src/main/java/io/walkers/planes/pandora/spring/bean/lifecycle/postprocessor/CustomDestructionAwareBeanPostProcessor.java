package io.walkers.planes.pandora.spring.bean.lifecycle.postprocessor;

import io.walkers.planes.pandora.spring.bean.lifecycle.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * Spring Bean 销毁前置处理器
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class CustomDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (User.class.isAssignableFrom(bean.getClass())) {
            System.out.println("User 对象销毁前置阶段");
        }
    }
}
