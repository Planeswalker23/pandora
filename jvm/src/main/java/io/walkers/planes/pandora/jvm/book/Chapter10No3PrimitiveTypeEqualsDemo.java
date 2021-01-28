package io.walkers.planes.pandora.jvm.book;

/**
 * 10.3 语法糖
 * @get 1. 包装类的“==”运算在遇到算术运算的情况下会自动拆箱
 * @get 2. 包装类 equals() 方法不处理数据转型的关系
 * @author Planeswalker23
 * @date Created in 2020/4/7
 */
public class Chapter10No3PrimitiveTypeEqualsDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        // 常量池对象
        System.out.println(c==d);

        // Integer 常量池缓存对象 -128~127
        System.out.println(e==f);

        // 包装类的“==”运算在遇到算术运算的情况下会自动拆箱
        System.out.println(c==(a+b));

        // 包装类 equals() 方法不处理数据转型的关系，即首先判断是否属于本类型
        System.out.println(c.equals(a+b));

        // 包装类的“==”运算在遇到算术运算的情况下会自动拆箱
        System.out.println(g==(a+b));

        // 包装类 equals() 方法不处理数据转型的关系，即首先判断是否属于本类型
        System.out.println(g.equals(a+b));
    }
}
