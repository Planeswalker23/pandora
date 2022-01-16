package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/submissions/">
 * 剑指 Offer 25. 合并两个排序的链表
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;


        MergeTwoLists demo = new MergeTwoLists();
        ListNode result = demo.mergeTwoLists(a, d);
        System.out.println("result: " + result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
