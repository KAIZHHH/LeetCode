package LinkedList;

/**
 * @author kai
 * @date 2022/1/14 上午2:04
 */
/*
分别让ab指针遍历完各自的链表 后为null再遍历彼此的 走过的总长度相等 即可以相交
 */
public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

}
