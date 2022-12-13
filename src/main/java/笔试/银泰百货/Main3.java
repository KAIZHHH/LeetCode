package 笔试.银泰百货;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/23 下午7:02
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int test = test(n, prices);
        System.out.println(test);
    }

    public static int test(int n, int[] prices) {
        if (n == 0) return 0;
        int k = Math.min(2, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = Integer.MIN_VALUE / 2;
            sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(buy[i - 1][j - 1] + prices[i], sell[i - 1][j]);
            }
        }
        int res = sell[n - 1][0];
        for (int i = 1; i <= k; i++) {
            res = Math.max(res, sell[n - 1][i]);
        }
        return res;
    }
}
