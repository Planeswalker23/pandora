package io.walkers.planes.pandora.jdk.thread.state;

/**
 * @author planeswalker23
 * @date 2021/9/12
 */
public class StateRunnable {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread state is: " + Thread.currentThread().getState()));
        thread.start();
    }
}
