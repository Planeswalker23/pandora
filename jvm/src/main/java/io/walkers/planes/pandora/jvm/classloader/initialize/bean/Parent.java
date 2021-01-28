package io.walkers.planes.pandora.jvm.classloader.initialize.bean;

import java.util.UUID;

/**
 * 父类
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class Parent {

    /**
     * 静态变量
     */
    public static String str = "static field";
    /**
     * 静态常量
     */
    public static final String STATIC_FINAL_STR = "static final field";
    /**
     * 编译期不确定的常量
     */
    public static final String STATIC_FINAL_UUID = UUID.randomUUID().toString();
    /**
     * 静态方法
     */
    public static void staticMethod() {
        System.out.println("static method");
    }

    static {
        System.out.println("loading parent class's static code block");
    }
}



