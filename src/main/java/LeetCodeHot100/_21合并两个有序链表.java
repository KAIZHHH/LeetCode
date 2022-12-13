package LeetCodeHot100;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/7/2 下午6:18
 */
/*
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]

 */
public class _21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode();
        ListNode cur = header;

        while (list1 != null && list2 != null) {
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
        } else {
            cur.next = list2;

        }
        return header.next;
    }
}
