package LinkedList;


/**
 * @author kai
 * @date 2022/5/21 下午1:14
 */
/*
 给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

 */
public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode header = new ListNode(0, head);
        ListNode cur = header;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        ListNode temp = header;
        while (cur != null) {
            cur = cur.next;
            temp = temp.next;
        }
        return temp;

    }
}
