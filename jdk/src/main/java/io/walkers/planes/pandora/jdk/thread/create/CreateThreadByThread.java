package io.walkers.planes.pandora.jdk.thread.create;

/**
 * 创建形成的方法：继承 Thread 类，重写 run 方法
 *
 * @author planeswalker23
 * @date 2021/9/13
 */
public class CreateThreadByThread extends Thread {

    @Override
    public void run() {
        System.out.println("CreateThreadByThread#run, 自定义的业务逻辑");
    }

    public static void main(String[] args) {
        Thread thread = new CreateThreadByThread();
        thread.start();
    }
}
