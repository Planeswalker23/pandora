package io.walkers.planes.pandora.jvm.memory;

/**
 * 模拟虚拟机栈及本地方法栈的溢出1
 * -Xss160k: 每个线程的栈大小为160k
 *
 * @author fanyidong
 */
public class StackOverflowError {

    private int stackLength = 1;

    public static void main(String[] args) {
        StackOverflowError stackOverflowError = new StackOverflowError();
        try {
            stackOverflowError.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length is " + stackOverflowError.stackLength);
            e.printStackTrace();
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
