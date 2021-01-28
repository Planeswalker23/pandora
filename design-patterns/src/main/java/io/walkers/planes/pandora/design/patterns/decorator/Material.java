package io.walkers.planes.pandora.design.patterns.decorator;

/**
 * 奶茶原料父类，所有制作奶茶的原来都需要继承这个类
 * Component抽象构件：是一个接口或者是抽象类,就是定义我们最核心的对象,也就是最原始的对象
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public abstract class Material {
    /**
     * 该奶茶原料的名字
     */
    private String name;

    /**
     * 获取已加入的原料
     */
    public String getFullName() {
        return this.name;
    }
    /**
     * 费用
     */
    public abstract double cost();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
