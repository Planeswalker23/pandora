package io.walkers.planes.pandora.design.patterns.singleton;

/**
 * 单例模式-懒汉式
 * 第二种写法：给获取单例对象的方法加上synchronized同步锁
 * 总结：适用于多线程，但加锁后开销加大，获取实例的方法效率低
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public class Singleton2 {

    // 声明单例对象为private，并不进行实例化
    private static Singleton2 instance = null;

    // 同时声明类的构造方法为private，使得无法在此类外进行实例化
    private Singleton2() { }

    // 获得单例对象的方法
    public static synchronized Singleton2 getInstance() {
        // 判断对象是否已实例化，没有实例化才new一个新的对象
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
