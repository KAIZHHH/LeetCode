package String;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/11/30 下午5:20
 */
/*
给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。

输入：sequence = "ababc", word = "ab"
输出：2
解释："abab" 是 "ababc" 的子字符串。

输入：sequence = "ababc", word = "ba"
输出：1
解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 */
public class 最大重复子字符串 {
    public static void main(String[] args) {
        String sequence = "ababc";
        String word = "ba";
        int i = maxRepeating(sequence, word);
        System.out.println(i);

    }

    //时间复杂度O(n^2)
    //空间复杂度O(1)
    public static int maxRepeating(String sequence, String word) {
        int sLen = sequence.length();
        int len = word.length();

        if (len > sLen) {
            return 0;
        }
        if (sequence.equals(word)) {
            return 1;
        }
        int res = 0;
        int left = 0;
        int maxCount = 0;
        boolean flag = false;
        while (left <= sLen - len) {
            if (sequence.substring(left, left + len).equals(word)) {
                res++;
                left += len;
                flag = true;
            } else {
                // 如果上一次有匹配, 那就需要回到上一次节点的开始, 不然可能会出现 aaabaaabaaaaba 只有一次的情况, 需要会到第二个a那里
                if (flag) {
                    left = left - len + 1;
                    flag = false;
                } else {
                    left++;
                }
                maxCount = Math.max(maxCount, res);
                res = 0;
            }
        }
        maxCount = Math.max(maxCount, res);
        return maxCount;
    }
}