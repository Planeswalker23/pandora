package io.walkers.planes.pandora.design.patterns.adapter;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-10
 */
public class Test {
    public static void main(String[] args) {
        // 拿到游戏机，发现插座不匹配不能充电
        JapanesePlug adaptee = new JapanesePlug();
        adaptee.powerForJapanese();
        System.out.println("警告：因为日版充电器不匹配中国插座，无法充电");
        //需要先创建一个被适配类的对象作为参数
        ChinesePlug target = new PlugAdapter(adaptee);
        target.powerForChinese();
    }
}
