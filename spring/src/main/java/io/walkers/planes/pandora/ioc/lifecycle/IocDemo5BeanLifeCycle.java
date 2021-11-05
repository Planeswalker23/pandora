package io.walkers.planes.pandora.ioc.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean Life Cycle 生命周期：
 * <p>
 * （1）通过构造器创建 bean 实例（无参数构造）
 * （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
 * （3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
 * （4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
 * （5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
 * （6）获取 bean 成功，使用 bean
 * （7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
 *
 * @author planeswalker23
 */
public class IocDemo5BeanLifeCycle {

    @Test
    public void beanLifeCycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/ioc-demo5-bean-life-cycle.xml");
        UserLifeCycle userLifeCycle = applicationContext.getBean("userLifeCycle", UserLifeCycle.class);
        System.out.println("4. 获取 Bean 实例");
        System.out.println(userLifeCycle);
    }
}
