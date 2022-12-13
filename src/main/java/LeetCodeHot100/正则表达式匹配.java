package LeetCodeHot100;

/**
 * @author kai
 * @date 2022/6/15 上午9:39
 */
/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

//https://www.bilibili.com/video/BV1wg411E72T?spm_id_from=333.337.search-card.all.click&vd_source=a81474b1b4d906df3173891054419ef2
 */
public class 正则表达式匹配 {
    public static void main(String[] args) {
        String s = "aaaaab";
        String p = ".*b";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //初始化：默认s为空
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[1][i - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //匹配i到j：当j为'*'
                if (p.charAt(j) == '*') {
                    //【.*】:
                    if (p.charAt(j - 1) == '.') {
                        //：.匹配0次 || .匹配1次 || .匹配n次
                        if (dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1]) {
                            dp[i][j] = true;
                        }
                    } else {//【x*】:
                        //*匹配0次 || *匹配1次 || *匹配n次
                        if (dp[i + 1][j - 1] || dp[i + 1][j] || (s.charAt(i) == p.charAt(j - 1) && dp[i][j + 1])) {
                            dp[i + 1][j + 1] = true;

                        }
                    }

                } else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {//p.charAt(j) == 字母
                    if (s.charAt(i) == p.charAt(j)) {//如果i和j匹配 就等于i前一个和j前一个 匹配情况
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                }

            }


        }
        return dp[m][n];
    }
}
