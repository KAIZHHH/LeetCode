package 笔试.美团;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/5/14 上午10:20
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");

        int n = Integer.valueOf(s1[0]);
        int m = Integer.valueOf(s1[1]);
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int test = test(arr, n, m);
        System.out.println(test);
    }

    public static int test(char[][] arr, int n, int m) {
        int res = 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {//hang
            if (arr[0][i] == 'o') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {//lie
            if (arr[i][0] == 'o') {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 'o') {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else {//x
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
