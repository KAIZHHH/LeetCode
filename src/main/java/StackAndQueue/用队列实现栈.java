package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kai
 * @date 2022/1/23 上午12:04
 */
/*
Queue 方法：

1、offer()和add()的区别
offer()和add()：都是向队列中添加一个元素在队尾
当队列为满，offer()方法会返回false，add()会抛出unchecked异常
、
2、peek()和element()的区别
peek()和element()：获取队首的元素，但不从队列中移除
当队列为空时，peek()返回null，element()方法会抛出NoSuchElementException异常

3、poll()和remove()的区别
poll()和remove()：获取队首的元素，并从队列中移除，
当队列为空时，poll()返回null，remove()会抛出NoSuchElementException异常。
 */
public class 用队列实现栈 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();//临时队列
        }

        /**
         * void push(int x) 将元素 x 压入栈顶。
         *
         * @param x
         */
        public void push(int x) {
            queue2.offer(x);//offer():在队尾添加元素
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());//poll():获取队首的元素，并从队列中移除
            }
            //交换队列
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * int pop() 移除并返回栈顶元素。
         *
         * @return
         */
        public int pop() {
            return queue1.poll();
        }

        /**
         * int top() 返回栈顶元素。
         *
         * @return
         */
        public int top() {
            return queue1.peek();
        }

        /**
         * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
         *
         * @return
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }


}
