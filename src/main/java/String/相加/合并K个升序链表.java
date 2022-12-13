package String.相加;

import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/5/18 下午12:24
 */

/*
给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]
 */
public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode[] lists = {new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(5, new ListNode(6)))};
        ListNode mergeKLists = mergeKLists(lists);
        System.out.println(mergeKLists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode node : lists) {
            res = merge(res, node);
        }
        return res;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode cur = header;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return header.next;
    }
}
