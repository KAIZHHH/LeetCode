package DynamicProgramming;

class 最小路径和 {
    public static void main(String[] args) {
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }


        return dp[m - 1][n - 1];
    }

    //好傻的做法
    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;

        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;

        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                dp[1][1] = grid[0][0];
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
