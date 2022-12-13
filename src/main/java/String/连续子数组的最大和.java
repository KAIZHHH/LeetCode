package String;

/**
 * @author kai
 * @date 2022/7/31 上午11:20
 */
/*
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //贪心法

    public static int maxSubArray1(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int x : nums) {
            //判断:x+下个数、x 如果加和结果更大则保存 不大则不加 舍弃掉
            pre = Math.max(pre + x, x);
            //比较
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
