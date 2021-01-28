package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 被动引用示例3——常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 * 不执行{@link Parent}类的静态代码块，代表引用类的静态常量，不触发类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivedQuoteDemo3 {

    public static void main(String[] args) {
        System.out.println(Parent.STATIC_FINAL_STR);
    }
}