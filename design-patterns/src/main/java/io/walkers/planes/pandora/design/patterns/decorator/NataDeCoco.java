package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 配料:椰果
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class NataDeCoco extends Burden {

    public NataDeCoco(Material material) {
        this.setMaterial(material);
    }

    @Override
    public String getFullName() {
        return this.getMaterial().getFullName() + " + 椰果";
    }

    @Override
    public double cost() {
        return 1 + this.getMaterial().cost();
    }
}
