package io.walkers.planes.pandora.jvm.classloader.initialize;

import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Child;
import io.walkers.planes.pandora.jvm.classloader.initialize.bean.Parent;

/**
 * 7.2 类加载的时机
 * 被动引用示例1——通过子类引用父类的静态字段，不会导致子类初始化
 * 解释：对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
 * 仅执行{@link Parent}类的静态代码块，不执行{@link Child}类的静态代码块，代表通过子类引用父类的静态字段，不会导致子类初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivedQuoteDemo1 {

    public static void main(String[] args) {
        System.out.println(Child.str);
    }
}