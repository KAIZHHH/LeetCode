package LeetCodeHot100;

import com.graphbuilder.struc.Stack;
import org.junit.Test;

/**
 * @author kai
 * @date 2022/8/10 下午10:19
 */
/*
输入一串字符串，每次可以选择对一对组合合法的括号子串删除，若干次操作后，字符串的最短长度为？
输入：(x))(?(())9 输出：7
 */
public class 求几组括号 {
    @Test
    public void test() {
        String s = "(x))(?(())9";
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                if (stack.peek() == "(") {
                    stack.pop();
                }
            }
        }
        System.out.println(stack.size());
    }
}
