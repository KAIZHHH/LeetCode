package StackAndQueue;

import java.util.Stack;

/**
 * @author kai
 * @date 2022/1/22 下午11:25
 */
/*
Stack：peek()和pop()
stack1.peek() 返回栈顶元素，但不在堆栈中删除它。
stack2.pop() 返回栈顶元素，并在堆栈中删除它。
 */
//用两个栈实现队列
public class 用栈实现队列 {
    class MyQueue {
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>(); // 负责进栈
            stackOut = new Stack<>();// 负责出栈
        }

        /**
         * void push(int x) 将元素 x 推到队列的末尾
         *
         * @param x
         */
        public void push(int x) {
            stackIn.push(x);
        }

        /**
         * int pop() 从队列的开头移除并返回元素
         *
         * @return
         */
        public int pop() {
            if (!stackOut.isEmpty()) {
                return stackOut.pop();
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }

        /**
         * int peek() 返回队列开头的元素
         *
         * @return
         */
        public int peek() {
            if (!stackOut.isEmpty()) {//出的栈不为空
                return stackOut.peek();//将其最上返回不删除
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }

        /**
         * boolean empty() 如果队列为空，返回 true ；否则，返回 false
         *
         * @return
         */
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

    }
}
