package DynamicProgramming.ZeroOne;

/**
 * @author kai
 * @date 2022/2/22 上午10:42
 */
/*
给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

输入：nums = [1], target = 1
输出：1

求装满背包有⼏种⽅法组合类：dp[j] += dp[j - nums[i]]

 */

public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    /**
     * 转成01背包：
     * 将nums数组分为两组：left+right
     * 数组和sum=left+right;
     * 目标和target=left-right
     * left=(sum+target)/2
     * 所以题目需要求：在容量为left的背包中，有多少种放法
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //奇数 直接返回
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int bagweight = (target + sum) / 2;
        if (bagweight < 0) bagweight = -bagweight;

        //01背包:dp[j] 表示：填满j（包括j）这么⼤容积的包，有dp[i]种方法
        int[] dp = new int[bagweight + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagweight; j >= num; j--) {
                dp[j] += dp[j - num];
                //dp[4]=dp[4]+dp[3]=0
                //dp[3]=dp[3]+dp[2]=0
                //dp[2]=dp[2]+dp[1]=0
                //dp[1]=dp[1]+dp[0]=1

                //dp[4]=dp[4]+dp[3]=0
                //dp[3]=dp[3]+dp[2]=0
                //dp[2]=dp[2]+dp[1]=0+1=1
                //dp[1]=dp[1]+dp[0]=1+1=2

                //dp[4]=dp[4]+dp[3]=0
                //dp[3]=dp[3]+dp[2]=0+1=1
                //dp[2]=dp[2]+dp[1]=1+1=2
                //dp[1]=dp[1]+dp[0]=2+1=3

                //dp[4]=dp[4]+dp[3]=0+1=1
                //dp[3]=dp[3]+dp[2]=1+1=2
                //dp[2]=dp[2]+dp[1]=2+1=3
                //dp[1]=dp[1]+dp[0]=3+1=4
            }
        }

        return dp[bagweight];
    }
}
