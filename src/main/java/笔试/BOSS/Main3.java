package 笔试.BOSS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kai
 * @date 2022/9/18 下午8:49
 */
public class Main3 {
    static int num;
    static int[] arr;
    static int[][] isUsed;
    static int p = 1;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        num = test();
        arr = new int[num + 2];
        isUsed = new int[num + 2][num + 2];
        int dp[][] = new int[num + 2][num + 2];
        for (int i = 1; i <= num; i++) {
            arr[i] = test();
            dp[i][i] = arr[i];
            isUsed[i][i] = i;
        }
        for (int l = 2; l <= num; ++l) {
            for (int i = 1; i <= num - l + 1; i++) {
                int j = i + l - 1;
                int t = 0;
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        t = dp[i][k] + dp[k + 1][j];
                    } else if (k == j) {
                        t = dp[i][k - 1] + dp[k][j];
                    } else {
                        t = dp[i][k - 1] * dp[k + 1][j] + dp[k][k];
                    }
                    if (t > dp[i][j]) {
                        dp[i][j] = t;
                        isUsed[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[1][num]);
        dfs(1, num);
    }

    public static int test() {
        int res = 0;
        try {
            int c = in.read();
            while (c < 48 || c > 57) {
                if (c == -1) return -1;
                c = in.read();
            }
            while (c >= 48 && c <= 57) {
                res = (res << 3) + (res << 1) + (c ^ 48);
                c = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void dfs(int l, int r) {
        if (l > r || l < 1 || r > num) return;
        int k = isUsed[l][r];
        if (p != num) System.out.print(k + " ");
        if (p == num) System.out.print(k + " ");
        p++;
        dfs(l, k - 1);
        dfs(k + 1, r);
    }
}



