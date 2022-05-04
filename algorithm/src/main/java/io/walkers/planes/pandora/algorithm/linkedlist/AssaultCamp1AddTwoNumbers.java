package io.walkers.planes.pandora.algorithm.linkedlist;

/**
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">
 * 2. 两数相加
 * </a>
 *
 * @author planeswalker23
 * @date 2022/5/4
 */
public class AssaultCamp1AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), tempResult = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 防止 l1 或 l2 为 null
            int curResult = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            // 处理进位
            if (carry > 0) {
                curResult++;
                carry--;
            }
            // 求和后，若大于10则标记进位
            if (curResult >= 10) {
                carry++;
                curResult -= 10;
            }
            // 创建求和后的节点，同时原始链表后移一位（需要考虑节点为 null 的情况）
            tempResult.next = new ListNode(curResult);
            tempResult = tempResult.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        // 考虑最后一位还有进位
        if (carry > 0) {
            tempResult.next = new ListNode(1);
        }
        // 返回 result 的第二个节点
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l17 = new ListNode(9);
        ListNode l16 = new ListNode(9, l17);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l1 = new ListNode(9, l12);

        ListNode l24 = new ListNode(9);
        ListNode l23 = new ListNode(9, l24);
        ListNode l22 = new ListNode(9, l23);
        ListNode l2 = new ListNode(9, l22);

        System.out.println(addTwoNumbers(l1, l2));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
