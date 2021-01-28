package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 测试类
 * @author Planeswalker23
 * @date Created in 2019-08-30
 */
public class Test {

    public static void main(String[] args) {
        // 通过构造方法传入MotorBike类策略，Person的travel方法只负责调用策略实现类的go方法
        Person me = new Person(new MotorBike());
        me.travel();
    }
}
