package DynamicProgramming;

/**
 * @author kai
 * @date 2022/3/10 下午7:40
 */
/*
买卖股票的最佳时机：购买和卖出一次 求最大的总利润

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    //动态规划
    public static int maxProfit(int prices[]) {
        //状态定义dp[i][j]:表示第i天 不持有股(0) 持有股(1)的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //今天不持有股票的最大利润 = 【前一天不持有股票利润、前一天持有股的利润+今天卖了股票的利润】二者取最大
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有股票的最大利润 = 【前一天持有股票利润 、前一天不持有股的利润-今天买了股票消费的】二者取最大
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        return dp[prices.length - 1][0];//最后一天不持有股 因为要卖掉才有利润
    }

}
