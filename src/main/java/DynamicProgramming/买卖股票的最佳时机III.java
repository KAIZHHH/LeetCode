package DynamicProgramming;

/**
 * @author kai
 * @date 2022/4/13 下午9:07
 */
/*
动态规划-》动态递推（系列题：前情回顾）
·状态定义dp[]：代表第i天的最大收益值，那么结果也就是dp[n]状态转移方程：dp[0]=Max(dp[i-1]-pricesl，dp[i-1]+prices1)
·注意：-prices叮代表买入股票，所以收益会是减掉，同理，+prices叮代表卖出股票，所以收益会是增加
·dpj代表是手中持有股票，还是没持有股票
·这样就可以得到转移方程
·dp【【o】代表手中没有股票=Max（dp【i-1】【o】，dp【i-1】【1】+prices【）
·dp【【1】代表手中有股票=Max（dp【i-1】【1】，dp【i-1】【O】-prices【）此时发现维度不够了，需要再继续增维度！！
 */

/*
逻辑思维的考验“时刻”
·其中新增一个维度是记录交易的次数，那么实际就有如下6种场景
·dp[i][0][0]：代表第i天没股票没卖过那么收益就是0
·dp[i][0][1]：代表第i天没股票卖过一次，那么可能是之前卖出的，也可能是今天卖出的：max（dp【i-1】【o【1】，dp【i-1】【1】【o】+prices）
·dp[i][0][2]：代表第i天没股票卖过两次，那么可能是之前卖出的，也可能是今天卖出的：max（dp【i-1】【o【2】，dp【i-1】【1】【1】+prices【
·dp[i][1][0]：代表第天有股票没有卖过，那么可能是之前买的，也可能是今天买的：max(dp[i-1][1][0],dp[i-1][0][0]-prices[i])
·dp[i][1][1]：代表第i天有股票卖过一次，那么可能是之前买的，也可能是今天买的：max(dp[i-1][1][1],dp[i-1][0][1]-prices[i])
·dp[i][1][2]：代表第天有股票卖出两次，这个按照题意是不可能出现的初始化的部分也是需要按照这个思路来一起写下哈~
 */
public class 买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //状态定义dp[i][j][k] 第i天   不持有股票j=0或者持有股票j=1  没卖过股票k=0或者卖过1次股票k=1或者卖过两次股票k=2
        int[][][] dp = new int[len][2][2];
        //初始化:
        //没不持有股票
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][0][2] = Integer.MIN_VALUE;
        //持有股票
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][1][2] = Integer.MIN_VALUE;

        //状态转移方程
        for (int i = 0; i < len; i++) {
            dp[i][0][0] = 0;
//            dp[i][0][1]=Math.max()

        }
        return 0;
    }
}
