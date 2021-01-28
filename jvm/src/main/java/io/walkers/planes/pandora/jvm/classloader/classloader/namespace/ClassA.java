package io.walkers.planes.pandora.jvm.classloader.classloader.namespace;

/**
 * 测试类
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class ClassA {

    public ClassA() {
        System.out.println("ClassA is loaded by: " + this.getClass().getClassLoader());
        new ClassB();
    }
}
