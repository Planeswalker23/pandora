package io.walkers.planes.pandora.jdk.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 范逸东(东稚)
 */
public class TestPrintAbcOrdered {

    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        reentrantLock(5);
        Thread.sleep(100);
        System.out.println("=====ReentrantLock=====");
        semaphore(5);
        Thread.sleep(100);
        System.out.println("=====Semaphore=====");
        countDownLatch(5);
        Thread.sleep(100);
        System.out.println("=====CountDownLatch=====");
    }

    private static CountDownLatch a = new CountDownLatch(0);
    private static CountDownLatch b = new CountDownLatch(1);
    private static CountDownLatch c = new CountDownLatch(1);

    public static void countDownLatch(int times) {
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    a.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("A");
                b.countDown();
                a = new CountDownLatch(1);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    b.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("B");
                c.countDown();
                b = new CountDownLatch(1);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("C");
                a.countDown();
                c = new CountDownLatch(1);
            }
        }).start();
    }

    public static void semaphore(int times) {
        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    a.acquire(); // a.permits=0
                    System.out.print("A");
                    b.release(); // b.permits=1, can print
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    b.acquire();
                    System.out.print("B");
                    c.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    c.acquire();
                    System.out.println("C");
                    a.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void reentrantLock(int times) {
        ReentrantLock lock = new ReentrantLock();

        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                lock.lock();
                try {
                    while (state % 3 != 0) {
                        a.await();
                    }
                    System.out.print("A");
                    state++;
                    b.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                lock.lock();
                try {
                    while (state % 3 != 1) {
                        b.await();
                    }
                    System.out.print("B");
                    state++;
                    c.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                lock.lock();
                try {
                    while (state % 3 != 2) {
                        c.await();
                    }
                    System.out.println("C");
                    state++;
                    a.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
