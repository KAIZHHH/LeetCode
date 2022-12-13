package StackAndQueue;

import java.util.Stack;

/**
 * @author kai
 * @date 2022/1/23 上午12:49
 */
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
#
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //左符号情况：放入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {//不是左符号情况：

                //1、stack为空时，添加右括号情况(一开始就添加右括号)
                if (stack.isEmpty()) {
                    return false;
                }
                //2、stack不为空时，添加右括号情况
                //先进行stack.pop()，再判断，所以每个都会进行pop，如果没有返回false，那么s.charAt(i 没有push，而且stack进行pop所以stack.isEmpty
                if (c == ')' && stack.pop() != '('//现在准备往栈加入')'，stack.pop()相当于stack里前一个元素，如果不是对应的'('，则为false
                        || c == '}' && stack.pop() != '{'
                        || c == ']' && stack.pop() != '[') {
                    return false;
                }
                /**
                 *  经过上层if循环判断后：
                 *  s.charAt(i == ')''}'']'只是用来判断，但没有添加到stack中
                 *  判断过程：stack.pop() != '('：把前一个元素弹出
                 *  如果返回true 则刚好 一对都不在stack中 继续判断char[]数组别的元素
                 */

            }

        }
        return stack.isEmpty();//相对应都会

    }
}
