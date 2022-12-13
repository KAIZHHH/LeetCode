package String;

/**
 * @author kai
 * @date 2022/4/23 下午8:18
 */
/*
输入：A = "abcde", B = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。

输入：A = "abc", B = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
示例 3：

输入：A = "abc", B = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。
 */
/*      a   b   w   c   e   g   f
        0   0   0   0   0   0   0
    a   0   1   1   1   1   1   1
    d   0   1   1   1   1   1   1
    c   0   1   1   2   2   2   2
    f   0   2   2   2   2   2   3

 */
public class 最长公共子序列_不连续dp_个数 {
    public static void main(String[] args) {
        String A = "abcde";
        String B = "def";
        int length = longestCommonSubsequence(A, B);
        System.out.println(length);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];//定义A里前i个字符和B里前j个字符的最大公共子序列数
        //默认赋值dp[i][j]=0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {//相等
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {//不相等
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[m][n];
    }
}
