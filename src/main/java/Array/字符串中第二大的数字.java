package Array;

/**
 * @author kai
 * @date 2022/11/23 下午4:57
 */
/*
给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
混合字符串 由小写英文字母和数字组成。

输入：s = "dfa12321afd"
输出：2
解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。

输入：s = "abc1111"
输出：-1
解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 */
public class 字符串中第二大的数字 {
    public static void main(String[] args) {
        String s = "abc22443211111";
        int i = secondHighest(s);
        System.out.println(i);
    }

    public static int secondHighest(String s) {
        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {//数字
                arr[c - '0']++;
            }
        }
        int num = 1;
        for (int i = 9; i >= 0; i--) {
            if (arr[i] > 0) {
                if (num == 0) {
                    return i;
                }
                num--;
            }
        }
        return -1;
    }
}
