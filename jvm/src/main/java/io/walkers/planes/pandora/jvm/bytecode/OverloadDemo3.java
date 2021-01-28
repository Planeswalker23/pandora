package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 方法重载示例3——继承与自动拆装箱
 * @author Planeswalker23
 * @date Created in 2020/5/24
 */
public class OverloadDemo3 {

//    public static void test(int o) {
//        System.out.println("int");
//    }

//    public static void test(Integer o) {
//        System.out.println("Integer");
//    }

    public static void test(int... s) {
        System.out.println("int...");
    }

//    public static void test(Object s) {
//        System.out.println("Object");
//    }

    public static void main(String[] args) {
        test(1);
    }
}
