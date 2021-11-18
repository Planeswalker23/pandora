package io.walkers.planes.pandora.spring.bean.definition;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Bean GC 示例，Bean 回收在关闭 Spring 容器后，由 JVM 进行垃圾回收
 *
 * @author planeswalker23
 * @date 2021/11/18
 */
@Configuration
public class BeanGCDemo {

    @Test
    public void gc() throws InterruptedException {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(BeanGCDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 依赖查找
        BeanGCDemo bean = applicationContext.getBean(BeanGCDemo.class);
        System.out.println(bean);
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
        Thread.sleep(1000L);
        // 帮助垃圾收集器进行垃圾回收！！！
        bean = null;
        // 强制触发 GC
        System.gc();
        Thread.sleep(1000L);
    }

    // ---------- Bean 回收 ----------
    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 BeanGCDemo 对象正在被垃圾回收");
    }
}
