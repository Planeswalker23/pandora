package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 配料抽象类，继承原料父类
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public abstract class Burden extends Material {

    /**
     * 配料类需要持有一个被修饰类，即奶茶
     */
    private Material material;

    /**
     * 配料类需要重写获取全部原料的方法，为了获得完成的原料
     * @return
     */
    public abstract String getFullName();

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
