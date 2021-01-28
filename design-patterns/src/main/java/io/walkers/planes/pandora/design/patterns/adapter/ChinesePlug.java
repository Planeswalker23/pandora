package io.walkers.planes.pandora.design.patterns.adapter;

/**
 * 中国的插头接口
 * Target目标角色：期望接口，包含Adaptee源角色未实现的方法
 * @author Planeswalker23
 * @date Created in 2019-09-09
 */
public interface ChinesePlug {

    /**
     * 待实现接口，将其他设备的充电器转化为可以插入中国插座的
     */
    void powerForChinese();
}
