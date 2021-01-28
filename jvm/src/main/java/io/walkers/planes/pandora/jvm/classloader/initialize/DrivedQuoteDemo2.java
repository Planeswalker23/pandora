package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Child;

/**
 * 7.2 类加载的时机
 * 被动引用示例2——通过数组定义来引用类，不会触发此类的初始化
 * 不执行{@link Child}类的静态代码块，代表通过数组定义来引用类，不会触发此类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivedQuoteDemo2 {

    public static void main(String[] args) {
        Child[] children = new Child[10];
    }
}