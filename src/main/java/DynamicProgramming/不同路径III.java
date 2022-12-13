package DynamicProgramming;

/**
 * @author kai
 * @date 2022/8/23 下午1:57
 */
public class 不同路径III {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 4, 1, 5},
                {5, 2, 7, 6},
                {4, 3, 2, 1}
        };
        int test = test(arr);
        System.out.println(test);

    }

    public static int test(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
}
