package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/">
 * 剑指 Offer 24. 反转链表
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ReverseList demo = new ReverseList();
        ListNode result = demo.reverseList(a);
        System.out.println(result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }
        return reverse;
    }
}
