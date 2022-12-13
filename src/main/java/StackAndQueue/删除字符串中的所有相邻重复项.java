package StackAndQueue;

import java.util.Stack;

/**
 * @author kai
 * @date 2022/1/23 下午8:30
 */
/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

pop:返回该元素，删除栈顶元素
peek:返回该元素，不删除栈顶元素
 */
public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = removeDuplicates(s);
        System.out.println(s1);
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //1、解决重复元素
        for (int i = 0; i < s.length(); i++) {
            //压栈：栈为空 / 此时栈顶元素和下个要加入的元素不等 (相等就要移除的！)
            if (stack.isEmpty() || stack.peek() != chars[i]) {
                stack.push(chars[i]);
            } else {
                stack.pop();//弹出栈 相当于 删除元素
            }
        }
        //2、声明个栈：将顺序调换
        Stack<Character> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        String res = "";
        while (!temp.isEmpty()) {
            Character pop = temp.pop();
            res += pop;
        }
        return res;


    }

    public static String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        char[] New = new char[stack.size()];
        for (int i = New.length - 1; i >= 0; i--) {
            New[i] = stack.pop();
        }
        return new String(New, 0, New.length);
    }
}
