package io.walkers.planes.pandora.jvm.classloader.initialize.bean;

/**
 * 子类
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class Child extends Parent {

    static {
        System.out.println("loading child class's static code block");
    }
}
