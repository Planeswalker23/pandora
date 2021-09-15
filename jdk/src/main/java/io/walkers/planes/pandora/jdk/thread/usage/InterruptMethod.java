package io.walkers.planes.pandora.jdk.thread.usage;

/**
 * {@link Thread#interrupt()}
 *
 * @author planeswalker23
 * @date 2021/9/14
 */
public class InterruptMethod {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 is running");
            try {
                // 为观察效果明显，将睡眠时间设置的长一点
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is over");
        });

        thread1.start();

        Thread.sleep(9000);

        // 中断线程
        thread1.interrupt();
    }
}
