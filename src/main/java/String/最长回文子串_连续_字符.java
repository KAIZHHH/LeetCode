package String;

/**
 * @author kai
 * @date 2022/4/26 上午8:29
 */
/*
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"

求：输出字符串中 最长的回文子串长度的字符

思路：
1、遍历字符串所有字符 调用expand(奇数)expand(偶数) 取最大的长度 确定start，start+len
2、expand()：确定满足回文串的长度
 */
public class 最长回文子串_连续_字符 {
    public static void main(String[] args) {
        String s = "babadb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    //先判断最长  再取start end
    public static String longestPalindrome(String s) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //以某个节点i开始 奇数搜索 偶数搜索 取最大的满足回文串的长度 len
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > max) {
                start = i - (len - 1) / 2;
                max = len;
            }
        }
        return s.substring(start, start + max);
    }

    public static int expand(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res = r - l + 1;
            l--;
            r++;
        }
        return res;
    }

}
