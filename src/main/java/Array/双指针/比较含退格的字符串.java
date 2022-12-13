package Array.双指针;

import java.util.Stack;

/**
 * @author kai
 * @date 2021/12/31 下午4:53
 */
/*
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
如果相等，返回 true ；否则，返回 false 。
注意：如果对空文本输入退格字符，文本继续为空。
示例 1：
输入：s = "ab#c", t = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。

示例 2：
输入：s = "ab##", t = "c#d#"
输出：true
解释：s 和 t 都会变成 “”。
 */
public class 比较含退格的字符串 {
    public static void main(String[] args) {
        String s = "a#c";
        String t = "#c";
        boolean b = backspaceCompare(s, t);
        System.out.println(b);
    }


    public static boolean backspaceCompare(String S, String T) {
        Stack a = new Stack<>();
        Stack b = new Stack<>();
        char[] s1 = S.toCharArray();
        char[] t1 = T.toCharArray();

        for (int i = 0; i < S.length(); i++) {
            if (s1[i] == '#') {
                if (a.isEmpty()) {
                    continue;
                }
                a.pop();
            } else {
                a.push(s1[i]);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (t1[i] == '#') {
                if (b.isEmpty()) {
                    continue;
                }
                b.pop();
            } else {
                b.push(t1[i]);
            }
        }
        return a.equals(b);
    }
}
