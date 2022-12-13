package 笔试.途虎养车;

import java.util.Arrays;

public class Test2 {
    public int change(int[] oils, int box) {

        int[] dp = new int[box + 1];
        Arrays.fill(dp, box + 1);
        dp[0] = 0;
        for (int oil : oils) {
            for (int i = 1; i <= box; i++) {
                if (i >= oil) {
                    dp[i] = Math.min(dp[i], dp[i - oil] + 1);
                }
            }
        }
        return dp[box] == box + 1 ? -1 : dp[box];
    }
}
