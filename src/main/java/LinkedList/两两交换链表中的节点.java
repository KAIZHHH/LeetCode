package LinkedList;

/**
 * @author kai
 * @date 2022/1/14 上午1:10
 */
/*
输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 */
public class 两两交换链表中的节点 {//交换相邻元素

    //虚拟头结点
    public ListNode swapPairs(ListNode head) {

        ListNode header = new ListNode(0, head);//虚拟头结点
        ListNode p = header;//头指针

        /*        p      n1  n2
                  |      |   |
              (header)——>1——>2——>3——>4——>5

                             p
                             |
              (header)——>2——>1——>3——>4——>5

         */
        while (p.next != null && p.next.next != null) {
            ListNode n1 = p.next;
            ListNode n2 = p.next.next;
            p.next = n2;//(header)——>2
            n2.next = n1;//2->1
            n1.next = n2.next;//1->3

            //第一组交换完毕 将p指针指向下一组
            p = n1;
        }
        return header.next;//头指针的下一个
    }


}
