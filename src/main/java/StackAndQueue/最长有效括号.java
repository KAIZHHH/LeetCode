package StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/5/30 上午11:26
 */
/*
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

输入：s = ""
输出：0
                                   dp[i-1]
括号：  (       )             (      (   )   )
下标：    i-dp[i-1]-2    i-dp[i-1]-1         i
dp[i]: 0                     0      0      dp[i]

 */
public class 最长有效括号 {
    public static void main(String[] args) {
        String s = "()(())";
        int i = longestValidParentheses1(s);
        System.out.println(i);
    }

    public static int longestValidParentheses1(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
