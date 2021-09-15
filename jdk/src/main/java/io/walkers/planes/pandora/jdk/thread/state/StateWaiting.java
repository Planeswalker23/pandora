package io.walkers.planes.pandora.jdk.thread.state;

/**
 * @author planeswalker23
 * @date 2021/9/12
 */
public class StateWaiting {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // sleep 100s 是为了有足够的时间查看线程状态
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        // 主线程等待 thread 线程执行完毕
        thread.join();
    }
}
