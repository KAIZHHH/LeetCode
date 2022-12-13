package LinkedList.Double;

/**
 * @author kai
 * @date 2022/1/13 下午12:47
 */
public class T1 {
    int size;
    ListNode head, tail;

    public T1() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        ListNode cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;

        }
        return cur.val;
    }

    public void addAtHead(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {

            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        newNode.prev = cur;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;

        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }

}
