package io.walkers.planes.pandora.jdk.thread.create;

/**
 * 创建形成的方法：实现 Runnable 接口，重写 run 方法
 *
 * @author planeswalker23
 * @date 2021/9/13
 */
public class CreateThreadByRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("CreateThreadByRunnable#run, 自定义的业务逻辑");
    }

    public static void main(String[] args) {
        Runnable runnable = new CreateThreadByRunnable();
        // 将 runnable 对象作为入参传入 Thread 类构造器
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
