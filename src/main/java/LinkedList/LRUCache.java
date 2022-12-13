package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/3/7 下午8:41
 */
/*
实现一个有前后指针的map
 */
//map的value存放LinkNode结点
class LinkNode {
    int key;
    int val;
    LinkNode front;
    LinkNode next;

    public LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    int capacity;
    Map<Integer, LinkNode> map = new HashMap<>();
    LinkNode head = new LinkNode(0, 0);//头结点(虚拟)
    LinkNode tail = new LinkNode(0, 0);//尾结点(虚拟)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //顺时针：head.........tail
        head.next = tail;
        tail.front = head;
    }

    /**
     * 根绝key获取map中的LinkNode结点
     * 有：移到最前面
     * 没有：返回-1
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;//没找到
        } else {
            LinkNode find = map.get(key);
            moveNodeToTop(find);
            return find.val;
        }
    }

    /**
     * 添加元素
     * key存在：找到对应的结点，将新的val替换，添加到最前面
     * key不存在：超过容量，删除最后结点，创建新结点，添加到最前面
     * key不存在：不超过容量，添加到最前面
     */
    public void put(int key, int val) {
        //不存在：将元素添加到首部
        if (!map.containsKey(key)) {
            //超过容量 先删除最后结点 再添加结点到最前面
            if (map.size() >= capacity) deleteLastNode();
            //没超过容量 添加结点到最前面
            LinkNode newNode = new LinkNode(key, val);//创建要添加的结点

            LinkNode temp = head.next;//定义记住头结点的下一个结点，新结点的下一个结点就是头结点的下一个结点

            //将新结点插入head之后
            head.next = newNode;
            newNode.front = head;
            newNode.next = temp;
            temp.front = newNode;
            map.put(key, newNode);


        } else {//存在：找到key对应的这个结点 将value替换，移到最前面

            LinkNode node = map.get(key);//拿到key对应的旧结点
            node.val = val;//赋值为新的val
            moveNodeToTop(node);
        }
    }

    /**
     * 删除最后结点
     */
    private void deleteLastNode() {
        LinkNode lastNode = tail.front;
        lastNode.front.next = tail;//直接让要最后的结点的前一个结点的next指向最后的结点的next
        tail.front = lastNode.front;
        map.remove(lastNode.key);
    }

    /**
     * 将该结点移到最前面
     * 现在还在map的链表中，将前后结点连接
     */
    private void moveNodeToTop(LinkNode node) {
        //让该结点前后链接
        node.front.next = node.next;
        node.next.front = node.front;
        //将该结点移到最前面
        LinkNode temp = head.next;//记住头结点下一个
        head.next = node;//头结点指向node
        node.front = head;//node前一个 指向 头结点
        node.next = temp;//node下一个 指向 temp
        temp.front = node;//temp上一个 指向 node
    }
}
