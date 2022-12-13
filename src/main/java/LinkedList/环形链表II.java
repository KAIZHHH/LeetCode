package LinkedList;

/**
 * @author kai
 * @date 2022/1/14 上午2:17
 */
/*
给定一个链表，返回链表开始入环的第一个节点,如果链表无环，则返回 null。

1、判断链表是否环
2、如果有环，如何找到这个环的入口

 */
public class 环形链表II {

    public ListNode detectCycle(ListNode head) {
        //1、判断链表是否环
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;

            }
        }
        //2、如果有环，如何找到这个环的入口
        if (!isCycle) {
            return null;
        } else {
            //当有环时，慢指针回到起点 快慢指针同时走一步能到交点
            slow = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
