package io.walkers.planes.pandora.jvm.classloader.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 29.30. 线程上下文加载器的一般使用模式 (获取 - 使用 - 还原)
 * <p>
 * 线程上下文类加载器的作用就是为了破坏java的类加载委托机制
 * 当高层提供了统一的接口让低层去实现, 同时又要在高层加载 (或实例化) 低层的类时, 就必须要通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类
 *
 * @author Planeswalker23
 * @date Created in 2020/4/27
 */
public class ThreadContextClassLoaderUsage {

    /**
     * 线程上下文加载器的一般使用模式 (获取 - 使用 - 还原)
     *
     * @param targetThreadContextClassLoader 使用该类加载器 to doSomething
     */
    public static void usageOfThreadContextClassLoader(ClassLoader targetThreadContextClassLoader) {
        // 获取
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            // 使用
            Thread.currentThread().setContextClassLoader(targetThreadContextClassLoader);
            // doSomething()里面调用了Thread.currentThread().getContextClassLoader(), 获取当前设定好的线程上下文加载器做某些事情
            doSomething();
        } finally {
            // 还原
            Thread.currentThread().setContextClassLoader(classLoader);
        }
    }

    private static void doSomething() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("获取当前设定好的线程上下文加载器做某些事情，如加载某些类");
    }

    /**
     * SPI示例: JDBC
     * 需要在pom中首先引入 mysql 驱动
     * output:
     * driver.getClass() = class com.mysql.jdbc.Driver, loader: sun.misc.Launcher$AppClassLoader@18b4aac2
     * driver.getClass() = class com.mysql.fabric.jdbc.FabricMySQLDriver, loader: sun.misc.Launcher$AppClassLoader@18b4aac2
     * 当前线程上下文加载器: sun.misc.Launcher$AppClassLoader@18b4aac2
     * ServiceLoader的类加载器: null
     */
    public static void spiDemoForThreadContextClassLoader() {

        // 修改线程上下文类加载器
//        Thread.currentThread().setContextClassLoader(MyClassLoader.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver.getClass() = " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());
    }

    public static void main(String[] args) {
        spiDemoForThreadContextClassLoader();
    }
}
