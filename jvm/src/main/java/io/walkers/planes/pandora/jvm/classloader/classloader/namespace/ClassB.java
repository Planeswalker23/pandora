package io.walkers.planes.pandora.jvm.classloader.classloader.namespace;

/**
 * 测试类2
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class ClassB {

    public ClassB() {
        System.out.println("ClassB is loaded by: " + this.getClass().getClassLoader());

//        System.out.println("from ClassB: " + ClassA.class);
    }
}
