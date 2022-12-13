package String;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/4/23 下午9:42
 */
/*
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

输入：nums = [0,1,0,3,2,3]
输出：4

输入：nums = [7,7,7,7,7,7,7]
输出：1
 
 */
public class 最长递增子序列_不连续_个数 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
