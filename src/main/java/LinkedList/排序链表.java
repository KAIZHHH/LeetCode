package LinkedList;

/**
 * @author kai
 * @date 2022/5/19 下午9:37
 */
/*
输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]
 */
//  4 2 1 3 -> 4 2、1 3 -> 4、2 、1、3 -> 2、4 、1、3
public class 排序链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        ListNode listNode = sortList(head);
        System.out.println(listNode);
    }

    //归并排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //快慢指针确定中间节点  将链表一分为二
        ListNode slow = head;
        ListNode fast = head;

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
