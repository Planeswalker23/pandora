package io.walkers.planes.pandora.design.patterns.template;

/**
 * 奔驰的实现类
 * @author Planeswalker23
 * @date Created in 2019-08-18
 */
public class Benz extends Car {
    /**
     * 启动的抽象方法
     */
    @Override
    protected void start() {
        System.out.println("Benz...start...");
    }

    /**
     * 钩子方法
     * 模板方法根据其返回值决定是否要响喇叭，子类可以覆写该返回值
     *
     * @return
     */
    @Override
    protected boolean isStart() {
        return false;
    }
}
