package LinkedList;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kai
 * @date 2022/6/4 上午11:05
 */
/*
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

输入：head = [1,2,2,1]
输出：true
示例 2：


输入：head = [1,2]
输出：false
 */
public class 回文链表 {
    List<Integer> vals = new ArrayList<Integer>();

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isParl(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (cur1 != null) {
            stack.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (cur2.val != stack.pop()) {
                return false;
            }
            cur2 = cur2.next;
        }
        return true;
    }
}
