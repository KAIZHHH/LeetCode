package LinkedList;

/**
 * @author kai
 * @date 2022/3/1 下午9:05
 */
/*
给你单链表的头指针 head 和两个整数 left 和 right ，
其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]
 */
public class 反转链表II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }

    /* pre2 cur
    head -> 1 2 3 4 5
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //定位
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 1; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode pre2 = pre;
        ListNode cur2 = cur;

        /*反转   pre  cur  temp
                 |    |  ....   |
               null left .... right
          */
        for (int i = left; i <= right; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //此时cur指向right的下个结点 pre指向right
        //衔接头部
        if (pre2 != null) {//不是从开头进行反转
            pre2.next = pre;
        } else {//从开头进行反转
            head = pre;
        }
        //衔接尾部
        cur2.next = cur;
        return head;
    }
}
