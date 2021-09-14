package io.walkers.planes.pandora.jdk.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建形成的方法：实现 Callable 接口，重写 run 方法
 *
 * @author planeswalker23
 * @date 2021/9/13
 */
public class CreateThreadByCallable implements Callable<Integer> {

    public static void main(String[] args) {
        CreateThreadByCallable callable = new CreateThreadByCallable();
        FutureTask<Integer> future = new FutureTask<>(callable);
        // 创建线程并启动
        Thread thread = new Thread(future);
        thread.start();

        Integer integer = null;
        try {
            integer = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("FutureTask 返回内容: " + integer);

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("CreateThreadByCallable#call, 自定义的业务逻辑，返回1");
        return 1;
    }
}
