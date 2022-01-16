package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">
 * 剑指 Offer 22. 链表中倒数第k个节点
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class GetKthFromEnd {

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

        GetKthFromEnd demo = new GetKthFromEnd();
        ListNode result = demo.getKthFromEnd(a, 2);
        System.out.println("result: " + result);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针比慢指针后移k位，当fast为null时，slow就是倒数第k个
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
