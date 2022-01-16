package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * 链表节点定义
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
