package 笔试.腾讯;

import java.util.HashMap;

/**
 * @author kai
 * @date 2022/4/24 下午8:43
 */
/*
给一个链表数组，数组中的每个链表是一个循环链表中的破碎的部分，且每个链表结点的值唯一且为数值类型，
求将这个循环链表复原以后，从链表中任意一个结点正序或逆序遍历 字典序 最小的那个链表，并返回。
思路：链表中结点的值唯一，使用字典记录结点的前驱和后继，并记录最小值，然后从最小值开始遍历，
并判断最小值的前驱和后继哪个更小，从更小的开始顺序遍历。

[{10,2,3},{7,4,5,1,10},{3,7,4}]
{1,5,4,7,3,2,10}

[{3,7,4},{7,4,5,1,10,3}]
{1,5,4,7,3,10}
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class 合并链表形成环形链表 {
    public static void main(String[] args) {
        ListNode[] a = new ListNode[3];
        a[0] = new ListNode(10, new ListNode(2, new ListNode(3)));
        a[1] = new ListNode(7, new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(10)))));
        a[2] = new ListNode(3, new ListNode(7, new ListNode(4)));
        ListNode solve = solve(a);
        System.out.println(solve.toString());

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类一维数组 指向每段碎片的开头
     * @return ListNode类
     */
    public static ListNode solve(ListNode[] a) {
        // write code here
        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        HashMap<Integer, Integer> preMap = new HashMap<>();
        HashMap<Integer, Integer> nextMap = new HashMap<>();
        HashMap<Integer, Boolean> visitedMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            printList(a[i]);
            for (ListNode p = a[i]; p != null; p = p.next) {
                nodeMap.put(p.val, p);
                if (p.next != null) {
                    preMap.put(p.next.val, p.val);
                    nextMap.put(p.val, p.next.val);
                }
                min = Math.min(min, p.val);
            }
        }
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode rear = head;
        rear.next = nodeMap.get(min);
        rear = rear.next;
        rear.next = null;
        visitedMap.put(min, true);
        if (preMap.get(min) < nextMap.get(min)) {
            //前驱小 从前驱走
            while (!visitedMap.getOrDefault(preMap.get(min), false)) {
                min = preMap.get(min);
                rear.next = nodeMap.get(min);
                rear = rear.next;
                rear.next = null;
                visitedMap.put(min, true);
            }

        } else {
            //后继小 从后继走
            //前驱小 从前驱走
            while (!visitedMap.getOrDefault(nextMap.get(min), false)) {
                min = nextMap.get(min);
                rear.next = nodeMap.get(min);
                rear = rear.next;
                rear.next = null;
                visitedMap.put(min, true);
            }
        }
        printList(head);
        return head.next;
    }

    public static void printList(ListNode head) {
        System.out.print("链表->{");
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
        System.out.println("}");
    }
}
