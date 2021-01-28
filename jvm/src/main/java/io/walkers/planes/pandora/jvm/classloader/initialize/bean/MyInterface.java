package io.walkers.planes.pandora.jvm.classloader.initialize.bean;

/**
 * 接口，包含一个default实现的接口方法
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public interface MyInterface {

    /**
     * 当一个接口中定义了JDK8新加入的默认方法（被default关键字修饰的接口方法）时，如果有这个接口的实现类发生了初始化，那该接口要在其之前被初始化。
     */
    default void methodInInterface() {
        System.out.println("invoke method in MyInterface");
    }

    /**
     * 若接口发生初始化，那么在初始化阶段会给该字段赋值，赋值时会报错
     * @throws ArithmeticException
     */
    int INIT_INT = 2 / 0;
}
