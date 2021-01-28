package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 主动引用示例1——创建类的实例(new Object)
 * 会执行{@link Parent}类的静态代码块，表示进行了类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo1 {

    public static void main(String[] args) {
        Parent parent = new Parent();
    }
}
