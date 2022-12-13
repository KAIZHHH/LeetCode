package DynamicProgramming;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/5/15 下午12:25
 */
/*
给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
设计一个算法使得这 m 个子数组各自和的最大值最小。

输入：nums = [7,2,5,10,8], m = 2
输出：18
解释：
一共有四种方法将 nums 分割为 2 个子数组。
其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。

输入：nums = [1,2,3,4,5], m = 2
输出：9
示例 3：

输入：nums = [1,4,4], m = 3
输出：4
 */
public class 分割数组的最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = splitArray(nums, 3);
        System.out.println(i);
    }

    public static int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        //前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i <len; i++) {
            preSum[i +1] = preSum[i] + nums[i];
        }

        //遍历所有状态
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    int i1 = preSum[i] - preSum[k];
                    int max = Math.max(dp[k][j - 1],i1 );
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }
        return dp[len][m];

    }
}
