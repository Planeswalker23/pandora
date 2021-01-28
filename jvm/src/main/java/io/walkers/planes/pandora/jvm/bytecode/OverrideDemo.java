package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 方法的动态分派（重写示例）
 * 方法的动态分派涉及到一个重要概念：方法接收者
 *
 * invokevirtual 字节码指令的多态查找流程:
 *      1. 首先到操作数栈栈顶寻找元素所指向对象的「实际类型」而不是静态类型；
 *      2. 在实际类型上寻找到符合条件（描述符、名称和访问权限）的方法，找到返回这个方法直接引用，整个多态查找过程结束。
 *      3. 如果没有找到就按照继承的层次关系从子类向上（向父类）依次寻找符合条件方法。如果一直到 Object 类都找不到，就会抛出异常。
 *
 * 比较方法重载（overload）与方法重写（overwrite),我们可以得到这样的结论:
 *      方法重载是静态的，是编译器行为；
 *      方法重写是动态的，是运行期行为。
 *
 * @author Planeswalker23
 * @date Created in 2020/5/19
 */
public class OverrideDemo {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();

    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}