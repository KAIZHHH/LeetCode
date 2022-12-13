package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/18 上午12:35
 */
/*
你可以无限次地完成交易，但是你每笔交易都需要付手续费。
如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
输出：8
解释：能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8

输入：prices = [1,3,7,5,10,3], fee = 3
输出：6    7-1-3+10-5-3=3+2
 */
public class 买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};

        int i = maxProfit(prices, 2);
        System.out.println(i);
    }

    // 动态规划
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    // 贪心思路
    public static int maxProfit1(int[] prices, int fee) {
        int buy = prices[0] + fee;//初始买入花费的金额
        int sum = 0;
        for (int p : prices) {
            //如果买入的金额花的更少则更换buy
            if (p + fee < buy) {//初始买入的费用更高的话
                buy = p + fee;
            }
            if (p > buy) {

                sum += p - buy;//利润
                buy = p;
            }
        }
        return sum;
    }
}
