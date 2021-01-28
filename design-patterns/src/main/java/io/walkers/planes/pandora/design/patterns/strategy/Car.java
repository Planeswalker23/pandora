package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 汽车
 * ConcreteStrategy具体策略角色：实现抽象策略中的操作，该类含有具体的算法。
 * @author Planeswalker23
 * @date Created in 2019-08-28
 */
public class Car implements TrafficTools {
    @Override
    public void go() {
        System.out.println("小汽车嘟嘟嘟嘟嘟");
    }
}
