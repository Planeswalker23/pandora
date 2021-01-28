package io.walkers.planes.pandora.design.patterns.singleton;

/**
 * 单例模式-懒汉式
 * 第五种写法：静态内部类
 * 总结：第一次加载Singleton类时并不会初始化instance，只有第一次调用getInstance方法时虚拟机加载SingletonHolder并初始化instance,这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public class Singleton5 {

    // 同时声明类的构造方法为private，使得无法在此类外进行实例化
    private Singleton5() { }

    // 获得单例对象的方法
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }

    // 静态内部类，调用getInstance方法时，加载静态内部类，创建实例
    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }
}
