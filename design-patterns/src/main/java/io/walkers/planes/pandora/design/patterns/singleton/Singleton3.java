package io.walkers.planes.pandora.design.patterns.singleton;

/**
 * 单例模式-懒汉式
 * 第三种写法：双重检查锁(DCL)
 * 总结：资源利用率高，第一次加载时才创建实例，效率高，但第一次稍慢，且会出现DCL失效
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public class Singleton3 {

    // 声明单例对象为private，并用volatile关键字修饰，保证可见性
    private static volatile Singleton3 instance = null;

    // 同时声明类的构造方法为private，使得无法在此类外进行实例化
    private Singleton3() { }

    // 获得单例对象的方法
    public static Singleton3 getInstance() {
        // 判断对象是否已实例化，没有实例化才new一个新的对象，第一次判断是为了不必要的同步
        if (null == instance) {
            // 加锁，准备创建实例
            synchronized (Singleton3.class) {
                // 再次判断实例是否已被实例化
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
