package LinkedList;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/7/10 下午10:56
 */
/*
给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
注意是节点的编号而非节点的数值。

输入：
cur even
 |  |
{1, 2,3,4,5}

   cur
返回值：
{1,3,5,2,4,6}

说明：
1->2->3->4->5->6->NULL
重排后为
1->3->5->2->4->6->NULL
 */
public class 链表的奇偶重排 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = oddEvenList(head);
        System.out.println(listNode);
    }

    public static ListNode oddEvenList(ListNode head) {
        //如果链表为空，不用重排
        if (head == null) return head;
        //odd开头指向第一个节点
        ListNode odd = head;
        //even开头指向第二个节点，可能为空
        ListNode even = head.next;

        //指向even开头
        ListNode evenhead = even;
        while (even != null && even.next != null) {
            //odd连接even的后一个，即奇数位
            odd.next = even.next;
            //odd进入后一个奇数位
            odd = odd.next;
            //even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            //even进入后一个偶数位
            even = even.next;
        }
        //even整体接在odd后面
        odd.next = evenhead;
        return head;
    }

}
