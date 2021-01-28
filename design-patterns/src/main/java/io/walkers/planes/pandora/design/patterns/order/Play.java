package io.walkers.planes.pandora.design.patterns.order;

/**
 * 具体的命令接收者:播放，执行播放的电路逻辑及代码
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class Play extends Receiver {
    @Override
    public void plan() {
        System.out.println("执行播放的电路逻辑及代码");
    }
}
