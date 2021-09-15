package io.walkers.planes.pandora.jdk.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.Lock}
 *
 * @author planeswalker23
 * @date 2021/9/15
 */
public class TestLock {

    private static class Counter {
        // 计数器
        private int count = 0;
        // 可重入锁
        private Lock lock = new ReentrantLock();

        public void add() {
            try {
                lock.lock();
                count++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.add();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter.count);
    }
}
