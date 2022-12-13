package LinkedList;

/**
 * @author kai
 * @date 2022/1/14 上午1:39
 */
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]

 */
public class 删除链表的倒数第N个节点 {
    //双指针 快慢指针 记录要删除结点的前后的结点
    /*
           f          f
         header ->  1,2,3,4,5
           s
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(head, 3);
        System.out.println(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode(0, head);
        ListNode fast = header;
        ListNode slow = header;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return header.next;
    }

}
