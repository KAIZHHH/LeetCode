package 笔试.BOSS;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/18 下午9:06
 */
public class Main5 {
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
        int[][] dp = new int[2][3];
        dp[1][1] = -arr[0];
        dp[1][2] = -arr[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[0][j] = Math.max(dp[0][j], dp[1][j] + arr[i]);
                dp[1][j] = Math.max(dp[1][j], dp[0][j - 1] - arr[i]);
            }
        }
        return dp[0][2];
    }

}
