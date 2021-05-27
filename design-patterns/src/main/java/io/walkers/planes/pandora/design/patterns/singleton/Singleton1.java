package io.walkers.planes.pandora.design.patterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式-懒汉式
 * 第一种写法：最简单的写法，只在第一次调用的时候进行实例化
 * 总结：适用于单线程，线程不安全
 * 缺点：两个线程同时运行到if判断时，可能出现同时为true的情况，可能获取到两个不同的Singleton1实例，不满足单例条件。
 * @author Planeswalker23
 * @date Created in 2019-05-30
 */
public class Singleton1 implements Serializable {

    // 声明单例对象为private，并不进行实例化
    private static Singleton1 instance = null;

    // 同时声明类的构造方法为private，使得无法在此类外进行实例化
    private Singleton1() {
        // 防止反射破坏单例
        if (instance == null) {
            throw new RuntimeException("单例对象已存在!");
        }
    }

    // 获得单例对象的方法
    public static Singleton1 getInstance() {
        // 判断对象是否已实例化，没有实例化才new一个新的对象
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * 控制反序列化，防止反序列化生成新对象
     * @return the_zan_of_singleton_pattern.Singleton1
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
