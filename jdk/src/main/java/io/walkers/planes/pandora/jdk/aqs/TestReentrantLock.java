package io.walkers.planes.pandora.jdk.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 范逸东(东稚)
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获得锁");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }));
        }

        for (int i = 0; i < 3; i++) {
            list.get(i).start();
        }
    }
}
