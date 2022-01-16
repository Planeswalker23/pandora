package io.walkers.planes.pandora.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/">
 * 剑指 Offer 35. 复杂链表的复制
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class CopyRandomList {

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
