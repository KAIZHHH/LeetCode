package LeetCodeHot100;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/6/24 上午12:19
 */
public class _2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode cur = header;
        int carry = 0;
        while (l1 != null || l2 != null) {//有一个为null 还可以继续 因为null的会赋值为0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return header.next;
    }
}
