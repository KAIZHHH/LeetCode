package 笔试.银泰百货;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/23 下午6:50
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int test = test(n, arr);
        System.out.println(test);
    }

    private static int test(int n, int[] arr) {
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -arr[i]);
        }
        return dp[n - 1][0];
    }
}
