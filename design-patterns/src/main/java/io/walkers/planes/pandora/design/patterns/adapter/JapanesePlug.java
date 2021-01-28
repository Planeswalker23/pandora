package io.walkers.planes.pandora.design.patterns.adapter;

/**
 * 客户希望使用的管理系统
 * Adaptee源角色：被转化的接口
 * @author Planeswalker23
 * @date Created in 2019-09-08
 */
public class JapanesePlug {
    /**
     * 充电方法：只能给日版的设备充电
     */
    public void powerForJapanese() {
        System.out.println("给日版设备充电");
    }
}
