package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Child;
import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 主动引用示例5——当初始化类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 * 会执行{@link Parent}类的静态代码块，表示进行了父类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo5 {

    public static void main(String[] args) {
        Child child = new Child();
    }
}
