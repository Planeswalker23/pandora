package io.walkers.planes.pandora.design.patterns.prototype;

import java.util.Date;

/**
 * 原型模式，实现Cloneable接口并重写clone方法
 * 测试Cloneable接口
 * Cloneable和Serializable一样都是标记型接口，它们内部都没有方法和属性.
 * 实现Cloneable接口表示该对象能被克隆，能使用Object.clone()方法。
 * @exception CloneNotSupportedException 如果没有implements Cloneable的类调用Object.clone()方法就会抛出CloneNotSupportedException。
 * @descirption clone的分类
 *              (1)浅克隆（shallow clone），浅拷贝是指拷贝对象时仅仅拷贝对象本身和对象中的基本变量，而不拷贝对象包含的数组和引用对象（直接复制地址）。
 *              (2)深克隆（deep clone），深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。
 * @author Planeswalker23
 * @date Created in 2019-08-19
 */
public class TestCloneable implements Cloneable {

    /**
     * String是final类，不可变，如果要改变是新建
     */
    private String str;

    private int num;

    private Date date;

    public TestCloneable() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestCloneable cloneable = new TestCloneable();
        cloneable.setStr("str");
        cloneable.setNum(1);
        cloneable.setDate(new Date());
        System.out.println(cloneable);

        // date属性是两个地址，对象进行深拷贝，而不是地址的引用
        TestCloneable cloneDto = cloneable.clone();
        System.out.println(cloneDto);
    }

    @Override
    protected TestCloneable clone() throws CloneNotSupportedException {
        TestCloneable testCloneable = null;
        testCloneable = (TestCloneable) super.clone();
        /**
         * 深拷贝，调用类内对象的clone方法
         * 浅拷贝，不调用类内对象的clone方法，类内对象是地址的引用
         */
        testCloneable.date = (Date) this.date.clone();
        return testCloneable;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestCloneable{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", date=" + date +
                '}';
    }
}
