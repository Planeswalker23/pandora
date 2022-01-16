package io.walkers.planes.pandora.algorithm.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">
 * 剑指 Offer 09. 用两个栈实现队列
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class CQueue {

    private Stack<Integer> head;
    private Stack<Integer> tail;

    public CQueue() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    public void appendTail(int value) {
        tail.add(value);
    }

    public int deleteHead() {
        if (tail.isEmpty() && head.isEmpty()) {
            return -1;
        }
        if (!head.isEmpty()) {
            return head.pop();
        } else {
            while (!tail.isEmpty()) {
                head.add(tail.pop());
            }
        }
        return head.pop();
    }
}
