package io.walkers.planes.pandora.design.patterns.order;

/**
 * 具体的命令接收者:暂停，执行暂停的电路逻辑及代码
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class Pause extends Receiver {
    @Override
    public void plan() {
        System.out.println("执行暂停的电路逻辑及代码");
    }
}
