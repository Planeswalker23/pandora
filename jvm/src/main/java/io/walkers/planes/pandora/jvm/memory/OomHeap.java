package io.walkers.planes.pandora.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆内存溢出
 * 设置堆内存最大值 -Xmx256m
 *
 * @author planeswalker23
 * @date 2021/2/6
 */
public class OomHeap {

    private byte[] byteObj = new byte[1024 * 1024];

    public static void main(String[] args) {
        List<OomHeap> list = new ArrayList<>();
        while (true) {
            list.add(new OomHeap());
        }
    }
}
