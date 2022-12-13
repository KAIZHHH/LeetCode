package LinkedList.Single;

/**
 * @author kai
 * @date 2022/1/13 下午12:18
 */
public class T1 {
    int size = 0;
    ListNode head;

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < size) {
            index = 0;
        }
        size++;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;

        }
        ListNode newnode = new ListNode(val);
        newnode.next = prev.next;
        prev = newnode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}
