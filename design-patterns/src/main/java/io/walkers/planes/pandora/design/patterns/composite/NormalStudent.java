package io.walkers.planes.pandora.design.patterns.composite;

/**
 * 普通干事，下级没有人
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public class NormalStudent extends Student {
    /**
     * 构造方法
     * @param name
     * @param identity
     */
    public NormalStudent(String name, String identity) {
        super(name, identity);
    }
}
