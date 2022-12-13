package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/1/14 上午2:19
 */
/*
给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //Fast指针一次走两步 slow走一步
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//相等 代表追上 代表有环
                return true;
            }
        }
        return false;
    }
}

