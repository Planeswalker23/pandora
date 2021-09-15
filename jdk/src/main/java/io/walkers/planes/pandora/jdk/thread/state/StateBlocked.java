package io.walkers.planes.pandora.jdk.thread.state;

/**
 * @author planeswalker23
 * @date 2021/9/12
 */
public class StateBlocked {

    private static String str = "lock";

    public static void main(String[] args) throws InterruptedException {
        blockByWait();
    }

    public static void blockByWait() {
        Thread thread1 = new Thread(() -> System.out.println("Thread1 start to run"));

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread1 start to run");
            try {
                thread1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 state is: " + thread1.getState());
            System.out.println("Thread2 state is: " + Thread.currentThread().getState());

        });

        thread1.start();
        thread2.start();
    }

    public static void blockByLock() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (str) {
                System.out.println("Thread1 get lock");
                // 防止线程 thread1 释放 str 锁资源
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        // 保证 thread1 先拿到锁资源
        Thread.sleep(1000);

        Thread thread2 = new Thread(() -> {
            synchronized (str) {
                System.out.println("Thread1 get lock");
            }
        });
        thread2.start();
        // 保证 thread2 进入 synchronized 代码块
        Thread.sleep(1000);
        System.out.println("Thread2 state is: " + thread2.getState());
    }
}
