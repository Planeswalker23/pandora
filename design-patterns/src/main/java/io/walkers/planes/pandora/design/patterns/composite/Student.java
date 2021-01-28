package io.walkers.planes.pandora.design.patterns.composite;

/**
 * 学生抽象类，学生的身份可能是主席、部长、干事等
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public abstract class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份
     */
    private String identity;

    /**
     * 构造方法
     * @param name
     * @param identity
     */
    public Student(String name, String identity) {
        this.name = name;
        this.identity = identity;
    }
    /**
     * 该学生的职责
     * 个体和整体都具有的共享方法
     */
    public void job() {
        System.out.println(this.name + "的职责是" + this.identity);
    }
}
