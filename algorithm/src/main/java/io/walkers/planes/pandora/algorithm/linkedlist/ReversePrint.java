package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">
 * 剑指 Offer 06. 从尾到头打印链表
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;

        ReversePrint demo = new ReversePrint();
        int[] result = demo.reversePrint(a);
        System.out.println(result);
    }

    public int[] reversePrint(ListNode head) {
        int[] res = new int[10000];
        int i = 0;
        while (head != null) {
            res[i++] = head.val;
            head = head.next;
        }
        int[] res2 = new int[i];
        for (int j = i - 1, index = 0; j >= 0; j--) {
            res2[index++] = res[j];
        }
        return res2;
    }
}
