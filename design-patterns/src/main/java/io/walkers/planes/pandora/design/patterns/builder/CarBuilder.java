package io.walkers.planes.pandora.design.patterns.builder;

import io.walkers.planes.pandora.design.patterns.template.Car;

/**
 * 建造者模式核心内容：汽车的建造者
 * 建造者模式最主要的功能是基本方法的调用顺序安排，也就是这些基本方法已经实现了，通俗地说就是零件的装配，顺序不同产生的对象也不同；
 * 而工厂方法则重点是创建，创建零件是它的主要职责，组装顺序则不是它关心的。
 * @author Planeswalker23
 * @date Created in 2019-08-18
 */
public abstract class CarBuilder {

    /**
     * 设置产品的不同部分，或产品流程的顺序，以获得不同的产品
     */
    public abstract void setOrder();

    /**
     * 获得产品类
     * @return {@link Car}
     */
    public abstract Car getModel();
}
