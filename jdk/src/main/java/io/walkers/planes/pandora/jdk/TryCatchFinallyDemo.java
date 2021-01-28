package io.walkers.planes.pandora.jdk;

/**
 * try-catch-finally 代码块中 finally 不会执行的特殊情况
 * @author Planeswalker23
 * @date Created in 2020/3/22
 */
public class TryCatchFinallyDemo {

    public static void main(String[] args) {
        System.out.println(demo5());
    }

    private static void demo1() {
        try {
            System.out.println("执行 try 代码块");
            System.exit(0);
        } finally {
            System.out.println("开始执行 finally 代码块");
        }
    }

    private static void demo2() {
        try {
            while (true) {
                // do something
                System.out.println("执行 try 代码块");
            }
        } finally {
            System.out.println("开始执行 finally 代码块");
        }
    }

    private static void demo3() {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("执行 try 代码块，等待2s，等待主线程执行结束...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("开始执行 finally 代码块");
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private static void demo4() {
        int i = 0;
        for (int j = 0; j < 10; j++) {
            try {
                i = 1;
                break;
            } finally {
                i = 2;
            }
        }
        System.out.println(i);
    }

    private static int demo5() {
        int i = 0;
        try {
            i = 1;
            return i;
        } finally {
            i = 2;
            return i;
        }
    }
}
