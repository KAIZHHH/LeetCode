package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/18 下午10:14
 */
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

 */
public class 爬楼梯 {
    public static void main(String[] args) {
        int i = climbStairs(2);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        //dp[i]表示到达i阶的方法数：都是由到达第i-1阶的方法数+到达第i-2阶的方法数
        // 【因为在i-1阶+1层就能到达i阶】【因为在i-2阶+2层就能到达i阶】
        int[] dp = new int[n + 1];
        //n=1
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
