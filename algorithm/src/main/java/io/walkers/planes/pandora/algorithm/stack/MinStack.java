package io.walkers.planes.pandora.algorithm.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/">
 * 剑指 Offer 30. 包含min函数的栈
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
