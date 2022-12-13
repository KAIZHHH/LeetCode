package 笔试.BOSS;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/18 下午8:58
 */
public class Main4 {
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
        if (n == 1) return 0;
        int[][][] dp = new int[n][2][3];
        dp[0][1][1] = -arr[0];
        dp[0][1][2] = -arr[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + arr[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - arr[i]);
            }
        }
        return dp[n - 1][0][2];
    }
}
