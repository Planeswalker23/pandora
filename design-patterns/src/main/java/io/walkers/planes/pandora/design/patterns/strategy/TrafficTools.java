package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 交通工具接口，拥有交通工具的抽象出行方法
 * Strategy抽象策略角色：策略、算法家族的抽象，通常为接口，定义每个策略或算法必须具有的方法和属性。
 * @author Planeswalker23
 * @date Created in 2019-08-28
 */
public interface TrafficTools {

    /**
     * 交通工具出行方法
     */
    void go();
}
