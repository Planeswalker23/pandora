package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 具体奶茶类，被装饰者
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class MilkTea extends Material {

    public MilkTea() {
        this.setName("奶茶");
    }

    @Override
    public double cost() {
        return 5;
    }
}
