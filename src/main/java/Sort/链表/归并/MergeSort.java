package Sort.链表.归并;


import CodeTop.ListNode;

/**
 * @author kai
 * @date 2022/9/7 下午2:39
 */
public class MergeSort {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        ListNode listNode = sortList(head);
        System.out.println(listNode);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        //1、先找中间节点 将链表一分为二
        while (fast.next != null && fast.next.next != null) {//一定要按照这个顺序
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nhead = slow.next;//记录新链表的头结点
        slow.next = null;
        //1、递归  分段到最小
        ListNode left = sortList(head);
        ListNode right = sortList(nhead);

        ListNode header = new ListNode(0);
        ListNode temp = header;

        //2、 再进行排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                header.next = left;
                left = left.next;
            } else {
                header.next = right;
                right = right.next;
            }
            header = header.next;
        }
        //退出while循环：left==null或者right==null:把不是空的链表接到头结点后
        if (left != null) {
            header.next = left;
        } else {
            header.next = right;

        }
        //3、返回 进行合并(归并)
        return temp.next;
    }
}
