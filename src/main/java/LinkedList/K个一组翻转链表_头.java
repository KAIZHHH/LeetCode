package LinkedList;

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

 */
class K个一组翻转链表_头 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        ListNode listNode = reverseKGroup(root, 3);
        System.out.println(listNode);
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

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a;
        while (cur != b) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }


}
