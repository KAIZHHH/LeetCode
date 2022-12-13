package DynamicProgramming;

/**
 * @author kai
 * @date 2022/8/11 下午11:40
 */
/*
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

输入: temperatures = [73,74,75,71,69,72,76,73]
                      1  1  1  1  1  1  1  1
                         1  1           5
                            1           4
                               0     2  max
输出: [1,1,4,2,1,1,0,0]

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]

输入: temperatures = [30,60,90]
输出: [1,1,0]
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    dp[i] = Math.min(j - i, dp[i]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = 0;
        }
        return dp;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
