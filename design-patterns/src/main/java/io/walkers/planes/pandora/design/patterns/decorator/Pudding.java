package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 布丁配料类
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class Pudding extends Burden {

    public Pudding(Material material) {
        this.setMaterial(material);
    }

    @Override
    public String getFullName() {
        return this.getMaterial().getFullName() + " + 布丁";
    }

    @Override
    public double cost() {
        return 2 + this.getMaterial().cost();
    }
}
