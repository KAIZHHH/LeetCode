package LinkedList;


import java.util.*;

/**
 * @author kai
 * @date 2022/6/8 下午1:51
 */
/*
输入：head = [1,1,2]
输出：[1,2]

输入：head = [1,1,2,3,3]
输出：[1,2,3]
 */
public class 删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }
        List<Integer> list = new ArrayList(set);
        Collections.sort(list);

        ListNode newNode = new ListNode();
        ListNode temp = newNode;
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);

            temp.next = new ListNode(integer);
            temp = temp.next;
        }
        return newNode.next;
    }
}
