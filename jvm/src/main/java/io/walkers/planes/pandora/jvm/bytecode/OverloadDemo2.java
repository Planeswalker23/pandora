package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 方法重载示例2——声明类型
 * @author Planeswalker23
 * @date Created in 2020/5/24
 */
public class OverloadDemo2 {

    public static void test(Object o) {
        System.out.println("Object");
    }

    public static void test(String s) {
        System.out.println("String");
    }

    public static void main(String[] args) {
        Object obj = new String("1");
        test(obj);
    }
}
