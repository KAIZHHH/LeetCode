package 笔试.百度;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/13 下午8:08
 */
/*
小红拿到了一个字符矩阵，矩阵仅由r、‘e‘、‘d三种字符组成。她 初始站在左上角，每次可以走到一个相邻的字符上（每个字符上、 下、左、右最多4个相邻)。但有个限制，小红不能从‘走到‘d‘， 从‘e走到‘r‘，从‘d‘走到‘e‘，其他情况都能走。
小红想知道，从左上角走到右下角至少需要多少步？

输入
复制
33
red
der
rdr
输出
复制
4
说明
小红可以走r→e→e→d→？，共需要移动4步。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s2 = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s2.charAt(j);
            }
        }
        int test = test(arr, m, n);
        System.out.println(test);
    }

    private static int test(char[][] arr, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (isValid(arr[0][i - 1], arr[0][i])) {
                dp[0][i] = dp[0][i - 1] + 1;

            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < m; i++) {
            if (isValid(arr[i - 1][0], arr[i][0])) {
                dp[i][0] = dp[i - 1][0] + 1;

            } else {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m - 1][n - 1];
    }

    private static boolean isValid(char c1, char c2) {
        if (c1 == 'r' && c2 == 'd') return false;
        if (c1 == 'e' && c2 == 'r') return false;
        if (c1 == 'd' && c2 == 'e') return false;
        return true;
    }
}

