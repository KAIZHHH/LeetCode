package 笔试.腾讯音乐;

/**
 * @author kai
 * @date 2022/9/8 下午7:12
 */
/*
1.给定只包含小写字母的字符串，每次可以选择两个相同的字符进行消除，
然后再末尾加上一个任意小写字母。问最少多少次操作可以使字符串内各字符都不同？
解法：贪心。肯定优先加上没出现的字符。如果都满了，那就都放在同一字符上消除。
具体来说，先进行一遍消除，使得26个位置尽可能满。如果剩余字符超过26，对多余处进行消除。
 */
public class Main1 {
    public static void main(String[] args) {
        int res = minOperations("abca");
        System.out.println(res);
    }
    public static int minOperations(String str) {
        // write code here
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            ans += count[i] / 2;
            count[i] %= 2;
            sum += count[i];
        }
        if (ans + sum < 26) {
            return ans;
        }
        return ans + ans - (26 - sum);
    }
}

