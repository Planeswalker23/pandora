package io.walkers.planes.pandora.design.patterns.template;

/**
 * 悍马的实现类
 * @author Planeswalker23
 * @date Created in 2019-08-18
 */
public class Hummer extends Car {
    /**
     * 启动的抽象方法
     */
    @Override
    protected void start() {
        System.out.println("Hummer...start...");
    }
}
