package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/">
 * 剑指 Offer 18. 删除链表的节点
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;

        DeleteNode demo = new DeleteNode();
        ListNode result = demo.deleteNode(a, 1);
        System.out.println("result: " + result);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    return head.next;
                } else {
                    pre.next = cur.next;
                    return head;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
