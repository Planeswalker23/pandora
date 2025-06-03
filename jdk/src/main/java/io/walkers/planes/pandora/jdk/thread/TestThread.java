package io.walkers.planes.pandora.jdk.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 范逸东(东稚)
 */
public class TestThread {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void method1() {
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println("锁定obj1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // 异常处理
                }
                synchronized (obj2) {
                    System.out.println("锁定obj2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj2) {
                System.out.println("锁定obj2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // 异常处理
                }
                synchronized (obj1) {
                    System.out.println("锁定obj1");
                }
            }
        }).start();
    }

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void method2() {
        new Thread(() -> {
            lock1.lock();
            try {
                System.out.println("锁定obj1");
                Thread.sleep(100);
                lock2.lock();
            } catch (Exception e) {

            } finally {
                lock1.unlock();
            }
        }).start();

        new Thread(() -> {
            lock2.lock();
            try {
                System.out.println("锁定obj2");
                Thread.sleep(100);
                lock1.lock();
            } catch (Exception e) {

            } finally {
                lock2.unlock();
            }
        }).start();
    }

    public static void main(String[] args) {
        method2();
    }
}
