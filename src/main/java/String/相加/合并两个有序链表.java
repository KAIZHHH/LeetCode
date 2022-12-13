package String.相加;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/3/9 下午1:54
 */
/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

输入：l1 = [], l2 = []
输出：[]
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, null)));

        ListNode listNode = Merge(l1, l2);
        System.out.println(listNode);

    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode header = new ListNode();
        ListNode cur = header;

        while (list1 != null && list2 != null) {//有一个为null都不能继续 因为两个值是需要进行比较
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }else{
            cur.next = list2;

        }
        return header.next;
    }
}

