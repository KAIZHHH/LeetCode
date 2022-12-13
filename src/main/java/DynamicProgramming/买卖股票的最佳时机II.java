package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/14 下午11:17
 */
/*
买卖股票的最佳时机II:可以多次购买和卖出 求最大的总利润
输入: prices = [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 利润 = 5-1 = 4 。
     在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 利润 = 6-3 = 3 。
 */
public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //今天不持有股票的最大利润 = 【前一天不持有股票利润、前一天持有股的利润+今天卖了股票的利润】二者取最大
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有股票的最大利润 = 【前一天持有股票利润 、前一天不持有股的利润-今天买了股票消费的】二者取最大

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }
        return dp[prices.length - 1][0];//最后一天不持有股 因为要卖掉才有利润
    }


    public static int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - prices[i - 1];
            int max = Math.max(value, 0);//跟0去比记录利润 小于0的都返回0
            result += max;
        }
        return result;
    }
}
