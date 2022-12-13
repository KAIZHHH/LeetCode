package LinkedList.Single;

/**
 * @author kai
 * @date 2022/1/12 上午11:04
 */
public class SingleLinkedList {

    int size;
    ListNode head;//虚拟头结点

    SingleLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //获取第index个结点的数值
    public int get(int index) {
        //如果index非法返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;//currentNode指向虚拟结点head
        //图示：currentNode->head->A->B->C
        //包含虚拟头结点，所以查找第 index+1 个节点
        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //如果 index 大于链表的长度，则返回空
        if (index > size) {
            return;
        }
        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pred = head;
        //找到要插入节点的前驱
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        //定义要插入的结点
        ListNode toAdd = new ListNode(val);

        toAdd.next = pred.next;
        pred.next = toAdd;

    }

    //删除第index个结点
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
