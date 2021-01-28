package io.walkers.planes.pandora.jvm.book;

/**
 * 3-2 一次对象自我拯救的演示
 * @get 1. 对象可以在被GC时自我拯救
 * @get 2. 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * @author Planeswalker23
 * @date Created in 2020/4/7
 */
public class Chapter3No2FinalizeEscapeGc {

    public static Chapter3No2FinalizeEscapeGc SAVE_HOOK = null;

    public static void isAlive() {
        if (SAVE_HOOK != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行 finalize() 方法");
        // 只要重新与引用链上的任何一个对象建立关联，使得该对象逃脱本次gc
        Chapter3No2FinalizeEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new Chapter3No2FinalizeEscapeGc();

        // save once
        System.out.println("save once");
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级较低，暂停0.5s，等待其执行
        Thread.sleep(500);
        isAlive();

        // try to save twice
        System.out.println("try to save twice");
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        isAlive();
    }
}
