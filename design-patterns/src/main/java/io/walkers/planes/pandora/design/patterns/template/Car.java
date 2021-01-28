package io.walkers.planes.pandora.design.patterns.template;

/**
 * 模板方法模式-抽象类，业务共性抽象成一个抽象类
 * 基本方法：由子类实现的方法，并且在模板方法被调用。如这里的start()、stop()方法。
 *         抽象模板中的基本方法尽量设计为protected类型，符合迪米特法则，不需要暴露的属性或方法尽量不要设置为protected类型。
 *         实现类若非必要，尽量不要扩大父类中的访问权限。
 * 模板方法：实现对基本方法的调度，为了防止恶意操作，一般用final关键字修饰，不允许被覆写
 * @author Planeswalker23
 * @date Created in 2019-08-18
 */
public abstract class Car {

    /**
     * 基本方法1
     * 启动的抽象方法
     */
    protected abstract void start();

    /**
     * 具体模板
     */
    private void stop() {
        System.out.println("熄火了...");
    }

    /**
     * 此方法是否调用由钩子方法决定
     */
    private final void didi() {
        System.out.println("DiDiDi，按喇叭...");
    }

    /**
     * 模板方法
     * 验收方法
     */
    public final void run() {
        // 车启动
        this.start();
        // 若钩子方法为true，则按下喇叭
        if (isStart()) {
            this.didi();
        }
        // 车熄火
        this.stop();
    }

    /**
     * 钩子方法
     * 模板方法根据其返回值决定是否要响喇叭，子类可以覆写该返回值
     * @return
     */
    protected boolean isStart(){
        return true;
    }
}
