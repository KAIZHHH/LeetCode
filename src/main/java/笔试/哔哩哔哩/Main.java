package 笔试.哔哩哔哩;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/9/1 下午7:30
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(1, new ListNode(4, new ListNode(7))))));
        ListNode listNode = mergeNode(head);
        System.out.println(listNode);
    }

    public static ListNode mergeNode(ListNode head) {
        ListNode newNode = new ListNode(0);
        ListNode cur = head;
        ListNode cur2 = head.next;

        ListNode newCur = newNode;
        while (cur2.next != null && cur2.next.next != null) {
            int val = cur.val * cur2.val;
            cur = cur.next.next;
            cur2 = cur2.next.next;

            newCur.next = new ListNode(val);
            newCur = newCur.next;
        }
        int val = cur.val * cur2.val;
        newCur.next = new ListNode(val);

        return newNode.next;
    }
}
