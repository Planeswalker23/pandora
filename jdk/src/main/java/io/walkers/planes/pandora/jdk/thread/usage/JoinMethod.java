package io.walkers.planes.pandora.jdk.thread.usage;

/**
 * {@link Thread#join()}
 *
 * @author planeswalker23
 * @date 2021/9/14
 */
public class JoinMethod {

    public static void main(String[] args) throws InterruptedException {
        testJoinLock();
    }

    private static String str = "123";

    private static void testJoinLock() throws InterruptedException {
        // main 线程先占用 str 资源
        synchronized (str) {
            Thread thread1 = new Thread(() -> {
                System.out.println("thread1 is running");
                synchronized (str) {
                    System.out.println("thread1 is get str lock");
                }
                System.out.println("thread1 is over");
            });

            thread1.start();
            thread1.join();
        }
    }

    private static void testJoin() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 is running");
            try {
                // 为观察效果明显，将睡眠时间设置的长一点
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is over");
        });

        thread1.start();
        thread1.join(40000);
    }
}
