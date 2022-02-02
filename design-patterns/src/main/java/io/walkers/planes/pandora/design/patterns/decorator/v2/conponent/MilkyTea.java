package io.walkers.planes.pandora.design.patterns.decorator.v2.conponent;

/**
 * 奶茶抽象类
 * 抽象组件（Component）：装饰器模式中最核心的对象，即原始对象，一般是一个接口或者是抽象类
 *
 * @author Planeswalker23
 * @date Created in 2022/02/02
 */
public abstract class MilkyTea {
    /**
     * 原料
     */
    public abstract String material();

    /**
     * 配料
     */
    public abstract String burden();

    /**
     * 奶茶详细描述，被装饰的方法
     */
    public String description() {
        return this.burden() + this.material();
    }
}
