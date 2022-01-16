package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/">
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode f = new ListNode(5);
        ListNode g = new ListNode(0);
        ListNode h = new ListNode(1);
        f.next = g;
        g.next = h;
        h.next = c;


        GetIntersectionNode demo = new GetIntersectionNode();
        ListNode result = demo.getIntersectionNode(a, f);
        System.out.println("result: " + result);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
