package io.walkers.planes.pandora.design.patterns.singleton;

/**
 * 单例模式-饿汉式
 * 第四种写法：简单的饿汉式
 * 优点：在类加载时就创建实例，类加载慢，但获取对象速度快，基于类加载机制避免了多线程的同步问题
 * 缺点：没有达到懒加载的效果，不能确定是否有其他方法导致类加载
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public class Singleton4 {

    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}

