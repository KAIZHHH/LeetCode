package StackAndQueue;

import java.util.Stack;

/**
 * @author kai
 * @date 2022/11/24 下午9:53
 */

/*
几组括号
 */
public class 求几组括号 {
    public static void main(String[] args) {
        int test = test("g(a)((m)())e");
        System.out.println(test);

    }
    public static int test(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
                sum++;
            }
        }
        return sum;
    }
}
