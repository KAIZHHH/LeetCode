package String;

/**
 * @author kai
 * @date 2022/8/6 下午11:22
 */
/*
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
rabbbit
rabbbit
rabbbit

输入：s = "babgbag", t = "bag"
输出：5
解释：
如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
babgbag
babgbag
babgbag
babgbag
babgbag
 */

public class 不同的子序列 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int i = numDistinct(s, t);
        System.out.println(i);
    }

    /*
    时间复杂度：O(mn)，其中 mm 和 nn 分别是字符串 ss 和 tt 的长度。二维数组dp 有 m+1 行和 n+1 列，需要对 dp 中的每个元素进行计算。
    空间复杂度：O(mn)，其中 mm 和 nn 分别是字符串 ss 和 tt 的长度。创建了m+1 行n+1 列的二维数组dp。
     */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]表示 s字符串的前i个字符中 满足t字符串的前j个字符的个数
        for (int i = 0; i <= m; i++) dp[i][0] = 1; //s=""+"123432" t="" 匹配的子序列是1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
        return dp[m][n];
    }
}
