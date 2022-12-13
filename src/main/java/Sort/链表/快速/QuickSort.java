package Sort.链表.快速;

import CodeTop.ListNode;
import acm.Main;

/**
 * @author kai
 * @date 2022/9/7 上午10:06
 */
public class QuickSort {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4, new ListNode(3, new ListNode(5, new ListNode(1, new ListNode(6, new ListNode(9))))));
        ListNode res = quickSort(listNode, null);

        System.out.println(res);

    }

    public static ListNode quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode p1 = head;
            ListNode p2 = head;

            while (p2 != end) {
                if (p2.val < head.val) {
                    p1 = p1.next;

                    int temp = p1.val;
                    p1.val = p2.val;
                    p2.val = temp;
                }
                p2 = p2.next;
            }

            //p1与基准交换
            if (p1 != head) {
                int temp = p1.val;
                p1.val = head.val;
                head.val = temp;
            }

            quickSort(head, p1);
            quickSort(p1.next, end);
        }
        return head;
    }

}
