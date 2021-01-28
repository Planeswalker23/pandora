package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 人对象，持有一个交通工具接口类，通过交通工具类具体实现出行方法
 * Context封装角色：它也叫做上下文角色，起承上启下封装作用，屏蔽高层模块对策略、算法的直接访问，封装可能存在的变化。
 * @author Planeswalker23
 * @date Created in 2019-08-28
 */
public class Person {

    /**
     * 持有策略实现对象
     */
    private TrafficTools tool;

    public Person(TrafficTools tool) {
        this.tool = tool;
    }

    /**
     * 旅行方法
     */
    public void travel() {
        tool.go();
    }
}
