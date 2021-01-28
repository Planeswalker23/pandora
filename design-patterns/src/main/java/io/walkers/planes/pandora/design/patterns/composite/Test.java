package io.walkers.planes.pandora.design.patterns.composite;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public class Test {
    public static void main(String[] args) {
        Minister chairman = new Minister("大王","主席");
        Minister minister = new Minister("小王","宣传部部长");
        NormalStudent student1 = new NormalStudent("一一","宣传部干事1");
        NormalStudent student2 = new NormalStudent("二二","宣传部干事2");
        // 构建组织架构树
        chairman.add(minister);
        minister.add(student1);
        minister.add(student2);
        // 展示树状结构
        chairman.getChildren();
        minister.getChildren();
    }
}
