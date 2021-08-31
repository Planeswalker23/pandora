package io.walkers.planes.pandora.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal示例
 * @author planeswalker23
 * @date Created in 2020/11/29
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        // 创建一个有两个核心线程数的线程池
        ExecutorService threadPool = new ThreadPoolExecutor(1000, 1001,
                1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10024));
        // 输出 ThreadLocal 中的内容
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(() -> threadLocal.set(new Long(1024*1024)));
        }
        threadPool.shutdown();
    }
}
