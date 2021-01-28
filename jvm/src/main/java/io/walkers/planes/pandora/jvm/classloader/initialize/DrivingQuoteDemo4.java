package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 主动引用示例4——调用一个类型的静态方法
 * 会执行{@link Parent}类的静态代码块，表示进行了类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo4 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("classloader.initialize.bean.Parent");
    }
}
