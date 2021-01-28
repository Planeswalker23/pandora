package io.walkers.planes.pandora.design.patterns.adapter;

/**
 * 适配器
 * Adapter适配器角色：将源角色装换为目标角色
 * @author Planeswalker23
 * @date Created in 2019-09-10
 */
public class PlugAdapter implements ChinesePlug {

    /**
     * 有一个日版充电器对象
     */
    private JapanesePlug japanesePlug;

    public PlugAdapter(JapanesePlug japanesePlug) {
        this.japanesePlug = japanesePlug;
    }

    /**
     * 待实现接口，将其他设备的充电器转化为可以插入中国插座的
     */
    @Override
    public void powerForChinese() {
        System.out.println("经过电源适配器的适配后");
        this.japanesePlug.powerForJapanese();
    }
}
