package LinkedList;

/**
 * @author kai
 * @date 2022/1/12 上午12:53
 */
/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]
示例 3：

输入：head = [7,7,7,7], val = 7
输出：[]
 */


public class 移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        /*
        temp
          |
        header->head
         */
        //多定义一个头结点:用来记录删除该节点的前一个结点
        ListNode header = new ListNode(0, head);//定义头结点
        ListNode temp = header;//定义temp指针 指向头结点

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;//head指向 head的next节点
            }
        }
        return header.next;
    }
}
