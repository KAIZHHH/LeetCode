package LeetCodeHot100;

/**
 * @author kai
 * @date 2022/7/1 下午10:01
 */
/*
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

输入：s = "cbbd"
输出："bb"
 */
public class _最长回文子串 {
    public static String test(String str) {
        int n = str.length();
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(spread(str, i, i + 1), spread(str, i, i));

            if (max < len) {
                max = len;
                start = i - (len - 1) / 2;
            }
        }
        return str.substring(start, start + max);
    }

    public static int spread(String str, int l, int r) {
        int res = 0;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            res = r - l + 1;
            l--;
            r++;
        }
        return res;
    }
}
