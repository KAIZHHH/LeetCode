package String.字符串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/7/24 下午8:34
 */
/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

输入：s = "3[a]2[bc]"
输出："aaabcbc"
 
 */
public class 字符串解码 {
    public String decodeString(String s) {
        Deque<String> strs = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        String str = "";
        int num = 0;
        int start = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strs.push(str);
                nums.push(num);
                str = "";
                num = 0;
            } else if (c == ']') {
                String currentStr = strs.pop();
                int currentNum = nums.pop();
                while (currentNum > 0) {
                    currentStr += str;
                    currentNum--;
                }
                str = currentStr;
            } else {//c='a'/'b'/'c'
                str += c;
            }
        }
        return str;
    }
}
