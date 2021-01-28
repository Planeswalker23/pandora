package io.walkers.planes.pandora.jvm.bytecode;

/**
 * 方法的静态分派（重载示例）
 *
 * Grandpa g1 = new Father();
 * 以上代码，g1 的静态类型是 Grandpa，而 g1 的实际类型（真正指向的类型）是 Father
 *
 * 我们可以得到这样一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），实际类型是在运行期才能确定。
 *
 * 方法重载在编译过程中即可完成识别，虚拟机根据传入参数的声明类型（静态类型）来选取重载方法，选取的过程分三个阶段：
 *  1. 在不考虑对基本类型自动装拆箱（auto-boxing，auto-unboxing），以及可变长参数的情况下选取重载方法；
 *  2. 如果在第 1 个阶段中没有找到适配的方法，那么在允许自动装拆箱，但不允许可变长参数的情况下选取重载方法；
 *  3. 如果在第 2 个阶段中没有找到适配的方法，那么在允许自动装拆箱以及可变长参数的情况下选取重载方法。
 *
 *  简而言之，就是先直接找，然后考虑自动装拆箱、然后考虑可变长参数。
 *
 * @author Planeswalker23
 * @date Created in 2020/5/19
 */
public class OverloadDemo {
    /**
     *
     * @param grandpa
     */
    public void test(Grandpa grandpa) {
        System.out.println("Grandpa");
    }
    public void test(Father father) {
        System.out.println("Father");
    }
    public void test(Son son) {
        System.out.println("Son");
    }

    /**
     * 方法重载，是一种静态的行为，编译期就可以完全确定。
     * 所以在 main 函数中的入参是根据参数的静态类型来确定调用哪个重载方法的。
     * @param args
     */
    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        OverloadDemo demo = new OverloadDemo();
        demo.test(g1);
        demo.test(g2);

    }
}

class Grandpa { }

class Father extends Grandpa { }

class Son extends Father { }