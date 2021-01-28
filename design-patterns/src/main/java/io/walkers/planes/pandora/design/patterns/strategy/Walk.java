package io.walkers.planes.pandora.design.patterns.strategy;

/**
 * 自己走路
 * @author Planeswalker23
 * @date Created in 2019-08-30
 */
public class Walk implements TrafficTools {
    @Override
    public void go() {
        System.out.println("自己走路");
    }
}
