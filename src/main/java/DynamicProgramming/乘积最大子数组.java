package DynamicProgramming;

/**
 * @author kai
 * @date 2022/8/10 上午12:56
 */
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组
（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
子数组 是数组的连续子序列。

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积；
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP；
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]);
            maxDP[i] = Math.max(nums[i], max);
            int min = Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]);
            minDP[i] = Math.min(nums[i], min);
            //取更大的
            res = Math.max(res, maxDP[i]);
        }
        return res;
    }
}
