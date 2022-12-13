package String;

/**
 * @author kai
 * @date 2022/4/23 上午8:51
 */

        /*
添加：
A->B：添加一个字符，前提是a中前i个字符已经和b中前j-1个字符相匹配 才能增加：
dp[i][j] = 1 + dp[i][j-1]
    i
A abc
        j
B abc   d
    j-1

删除：
A->B：删除一个字符，前提是a中前i-1个字符已经和b中前j个字符相匹配 才能删除：
dp[i][j] = 1 + dp[i-1][j]
    i-1 i
A abc   d
    j
B abc

替换：
1、A[i]==B[j]若两字符相同
dp[i][j] = 1 + dp[i-1][j-1]；

    i-1i
A abc  d
    j-1j
B abc  d

2、A[i]！=B[j]若两字符不相同：
dp[i][j] = dp[i-1][j-1]

    i-1i
A abc  d
    j-1j
B abc  e
*/
public class 编辑距离 {
    public static void main(String[] args) {
        int res = minDistance("horse", "ros");
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        //定义dp[i][j]：表示使得A中前i个字符 和 变为 B中前j个字符 相匹配 的最少的编辑次数
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        //一定要初始化
        //A中前i个字符变为B中0个字符需要进行i次删除操作
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //B中前i个字符变为A中0个字符需要进行i次删除操作
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //增加
                int add = dp[i][j - 1] + 1;
                //删除
                int delete = dp[i - 1][j] + 1;

                //先判断增加和删除 更小的操作数
                int min = Math.min(add, delete);

                int replace = 0;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace = dp[i - 1][j - 1] + 1;
                } else {
                    replace = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.min(min, replace);
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//
//            }
//            System.out.println();
//
//        }
        return dp[m][n];

    }
}

