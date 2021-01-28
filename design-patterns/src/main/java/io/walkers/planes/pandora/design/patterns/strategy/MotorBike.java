package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 骑上我心爱的小摩托
 * ConcreteStrategy具体策略角色：实现抽象策略中的操作，该类含有具体的算法。
 * @author Planeswalker23
 * @date Created in 2019-08-30
 */
public class MotorBike implements TrafficTools {
    @Override
    public void go() {
        System.out.println("骑上我心爱的小摩托，它永远不会堵车");
    }
}
