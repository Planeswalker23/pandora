package io.walkers.planes.pandora.jvm.memory;

/**
 * 模拟虚拟机栈 OOM
 * -Xss2M: 每个线程的栈大小为2M
 * 别运行，会卡死
 *
 * @author planeswalker23
 */
public class OomStack {

    public static void main(String[] args) {
        OomStack oomStack = new OomStack();
        oomStack.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getId() + " is created");
                dontStop();
            }).start();
        }
    }
}
