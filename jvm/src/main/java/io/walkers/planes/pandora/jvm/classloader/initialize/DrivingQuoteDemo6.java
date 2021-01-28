package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.ChildInterface;

/**
 * 7.2 类加载的时机
 * 主动引用示例6——当一个接口中定义了JDK8新加入的默认方法（被default关键字修饰的接口方法）时，如果有这个接口的实现类发生了初始化，那该接口要在其之前被初始化。
 * 抛出{@link ArithmeticException}异常，表示进行了{@link MyInterface}接口的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo6 {

    public static void main(String[] args) {
        io.walkers.planes.pandora.jvm.classloader.initialize.bean.ChildInterface child = new ChildInterface();
    }
}
