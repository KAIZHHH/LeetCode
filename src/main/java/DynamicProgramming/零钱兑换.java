package DynamicProgramming;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/21 下午9:16
 */
/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

输入：coins = [2], amount = 3
输出：-1

输入：coins = [1], amount = 0
输出：0
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        //定义dp[i]表示构成总金额为i 所需要的最少硬币数dp[i]
        int[] dp = new int[amount + 1];
        //找最小硬币数：先把所有赋值为大的
        Arrays.fill(dp, amount + 1);
        //初始化dp[0]
        dp[0] = 0;
        //遍历面值
        for (int coin : coins) {
            //遍历金额i：1-amount  dp[i]所需要的最少硬币数
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    //                     【不包含这枚coin的最少硬币数+1【coin这枚硬币数】】
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //还等于原来的数没有修改 证明没有硬币可以组成金额 返回-1：有则返回最大
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
