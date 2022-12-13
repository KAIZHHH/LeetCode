package LinkedList;


/**
 * @author kai
 * @date 2022/3/9 上午8:22
 */
/*
变形的链表反转题，大致描述如下
给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。（不能使用队列或者栈作为辅助）
例如： 链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。
调整后：1->2->5->4->3->8->7->6->null。其中 1，2不调整，因为不够一组。
 */

public class K个一组翻转链表_尾 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        ListNode listNode = reverseRes(root, 3);
        System.out.println(listNode);
    }

    public static ListNode reverseRes(ListNode head, int k) {
        //1、反转全部
        ListNode res = reverseAll(head);
        //2、分组反转
        ListNode listNode = reverseKGroup(res, k);
        //3、再反转
        ListNode res2 = reverseAll(listNode);

        return res2;
    }

    //2、分组反转
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

    public static ListNode reverseAll(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
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
