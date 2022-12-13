package LinkedList;


/**
 * @author kai
 * @date 2022/5/16 下午1:41
 */
/*
L0 → L1 → … → Ln - 1 → Ln

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

输入：head = [1,2,3,4]
输出：[1,4,2,3]

输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3]
 */

/*
寻找链表中点 + 链表逆序 + 合并链表
1 -> 2 -> 3 -> 4 -> 5 -> 6
第一步，将链表平均分成两半
1 -> 2 -> 3
4 -> 5 -> 6

第二步，将第二个链表逆序
1 -> 2 -> 3
6 -> 5 -> 4

第三步，依次连接两个链表
1 -> 6 -> 2 -> 5 -> 3 -> 4

 */
public class 排链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        reorderList(head);
        System.out.println(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }


    //找中点
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //2.反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 3. 合并链表head和head2
    /*           t1
                 |
         l1->1   2   3
             | /
         l2->5   4
                 |
                t2
     */
    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode t1;
        ListNode t2;
        while (l1 != null && l2 != null) {
            t1 = l1.next;
            t2 = l2.next;

            l1.next = l2;
            l1 = t1;

            l2.next = l1;
            l2 = t2;
        }
    }
}
