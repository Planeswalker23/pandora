package io.walkers.planes.pandora.jdk.thread.state;

/**
 * @author planeswalker23
 * @date 2021/9/12
 */
public class StateTerminated {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        // 等待线程 thread 执行完毕
        thread.join();
        System.out.println("Thread state is: " + thread.getState());
    }
}
