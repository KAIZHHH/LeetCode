package Greedy;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/7/19 上午9:24
 */
//例如： 链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。调整后：1->2->5->4->3->8->7->6->null。其中 1，2不调整，因为不够一组。
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));

        ListNode listNode = reverseKGroup(head, 3);
        System.out.println(listNode);

    }

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode pre = null;
        while (cur != b) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public static ListNode reverseKGroup(ListNode root, int k) {
        if (root == null) return null;
        ListNode a = root, b = root;
        for (int i = 0; i < k; i++) {
            // 小于 k 个，不需要反转
            if (b == null) return root;
            b = b.next;
        }
        ListNode newhead = reverse(a, b);
        // 递归反转后续链表，连接起来
        a.next = reverseKGroup(b, k);
        return newhead;
    }


}
