package DynamicProgramming;

/**
 * @author kai
 * @date 2022/4/23 上午8:51
 */

        /*
添加：
A到B添加一个字符，前提是a中前i个字符已经和b中前j-1个字符相匹配 才能增加：
dp[i][j] = 1 + dp[i][j-1]
    i
A abc
     j
B abcd

删除：
A到B删除一个字符，前提是a中前i-1个字符已经和b中前j个字符相匹配 才能删除：
dp[i][j] = 1 + dp[i-1][j]
     i
A abcd
    j
B abc

替换：
1、A[i]==B[j]若两字符相同：dp[i][j] = 1 + dp[i-1][j-1]；
    i-1i
A abc  d
    j-1j
B abc  d

1、A[i]！=B[j]若两字符不相同：dp[i][j] = dp[i-1][j-1]
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

    public static int minDistance(String A, String B) {
        //定义dp[i][j]：表示使得A中前i个字符 和 变为 B中前j个字符 相匹配 的最少的编辑次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        dp[0][0] = 0;
        //一定要初始化
        //A中前i个字符变为B中0个字符需要进行i次删除操作
        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = i;
        }
        //B中前i个字符变为A中0个字符需要进行i次删除操作
        for (int i = 1; i <= B.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                //增加
                int add = dp[i][j - 1] + 1;
                //删除
                int delete = dp[i - 1][j] + 1;

                //先判断增加和删除 更小的操作数
                int min = Math.min(add, delete);

                //再判断替换次数：两种情况
                //字符相同 默认不修改0
                int update = 0;
                //字符不相同 进行修改1
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    update = 1;
                }
                int replace = dp[i - 1][j - 1] + update;
                dp[i][j] = Math.min(min, replace);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();

        }
        return dp[A.length()][B.length()];

    }
}

