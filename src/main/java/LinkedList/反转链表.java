package LinkedList;

/**
 * @author kai
 * @date 2022/1/14 上午1:01
 */
/*
题意：反转一个单链表。

示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL

 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode e = new ListNode(5, null);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode node = reverseList(a);
        System.out.println(node);

    }


    /**
     * 反转链表：
     * 1、先记录cur.next的值:temp=cur.next
     * 2、断开cur.next 指向pre: cur.next=pre
     * 3、pre cur 向后移动：pre=cur,cur=temp;
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;//cur指针指向 head链表
        ListNode prev = null;//记录cur指针指向的前一个结点
        while (cur != null) {//当cur指向一个空结点 则返回prev
            ListNode  temp = cur.next;// 保存下一个节点 temp= 2
            cur.next = prev;           // cur.next=null
            prev = cur;                 //prev指向 原本cur指向的结点
            cur = temp;         //cur指向下一个结点
        }
        return prev;
    }

}
