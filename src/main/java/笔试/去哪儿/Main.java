package 笔试.去哪儿;

/**
 * @author kai
 * @date 2022/9/7 下午6:45
 */
public class Main {
    public static void main(String[] args) {
        int energy = 10;
        int[][] actions = {{1, 1}, {2, 3}, {3, 5}, {5, 10}, {7, 9}, {8, 10}};
        int i = maxScore(energy, actions);
        System.out.println(i);
    }

    public static int maxScore(int energy, int[][] actions) {
        int m = actions.length;
        int[] weight = new int[m];
        int[] values = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = actions[i][0];
        }
        for (int i = 0; i < m; i++) {
            values[i] = actions[i][1];
        }

        int[][] dp = new int[m + 1][energy + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < energy + 1; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + values[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][energy];

    }


}
