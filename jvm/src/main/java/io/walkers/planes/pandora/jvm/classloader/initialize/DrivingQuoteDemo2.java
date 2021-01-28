package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 主动引用示例2——读取或设置一个类型的静态字段
 * 会执行{@link Parent}类的静态代码块，表示进行了类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo2 {

    public static void read() {
        System.out.println("读取一个类型的静态字段");
        System.out.println(Parent.str);
    }

    public static void put() {
        System.out.println("设置一个类型的静态字段");
        Parent.str = "newParent";
    }

    public static void readFinal() {
        System.out.println("读取一个类型的静态常量字段，不会触发类的初始化");
        System.out.println(Parent.STATIC_FINAL_STR);
    }

    public static void main(String[] args) {
//        read();
//        put();
        readFinal();
    }
}
