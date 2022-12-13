package LinkedList;


/**
 * @author kai
 * @date 2022/5/16 下午2:21
 */
public class 排链表2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList1(head);
        System.out.println(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        //至少三个元素 head.size()>3
        ListNode pre = null;
        ListNode cur = head;
        ListNode sec = head.next;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }

        head.next = pre;
        pre.next = sec;
        reorderList(sec);

    }

    public static void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        //至少三个元素 head.size()>3
        ListNode pre = null;
        ListNode cur = head;

        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        ListNode sec = head.next;

        head.next = cur;
        cur.next = sec;
        pre.next = null;
        reorderList(sec);

    }
}
