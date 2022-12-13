package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/18 下午10:31
 */
/*
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
请你计算并返回达到楼梯顶部的最低花费。

输入：cost = [10,15,20]
输出：15
解释：你将从下标为 1 的台阶开始。
- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
总花费为 15 。

输入：cost = [1,100,1,1,1,100,1,1,100,1]
输出：6
解释：你将从下标为 0 的台阶开始。
- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
总花费为 6 。

 */
public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 100, 1, 1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);

    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //dp[i]的定义：到达第i个台阶所花费的最少体力为dp[i]
        int[] dp = new int[n + 1];//dp[0]、dp[1]、dp[2]、多一个dp[3]作为终点

        dp[0] = dp[1] = 0;
        //dp[i]：到下标i的最小花费：可以走一步到0，走两步到1 都不花费
        for (int i = 2; i <= n; i++) {
            //走两步：到达i-2的最少体力+从i-2到i的自身消耗的体力
            int i1 = dp[i - 2] + cost[i - 2];
            //走一步：到达i-1的最少体力+从i-1到i的自身消耗的体力
            int i2 = dp[i - 1] + cost[i - 1];
            //两者取最小作为dp[i]:到达i的消耗的最少体力
            dp[i] = Math.min(i2, i1);
        }
        return dp[n];
    }
}

