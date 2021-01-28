package io.walkers.planes.pandora.design.patterns.singleton;

/**
 * 单例模式-饿汉式
 * 第六种写法：枚举类单例
 * 优点：简单，枚举实例默认线程安全，单例，反序列化不会生成新的对象
 * 缺点：少用，可读性不高
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public enum Singleton6 {

    INSTANCE;

    // 业务方法
    public void serviceMethod() { }
}

