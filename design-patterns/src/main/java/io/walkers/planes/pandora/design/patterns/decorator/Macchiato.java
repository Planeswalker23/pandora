package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 玛奇朵类，继承于原料类
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class Macchiato extends Material {

    public Macchiato() {
        this.setName("玛奇朵");
    }

    @Override
    public double cost() {
        return 10;
    }
}
