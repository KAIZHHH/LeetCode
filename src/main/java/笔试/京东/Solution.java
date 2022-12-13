package 笔试.京东;

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];

        if (nums.length % 2 == 0) {//偶数

            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            dp[0] = 0;
            dp[1] = nums[0];
            dp[2] = Math.max(nums[0], nums[1]);
            for (int i = 3; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            return dp[nums.length];
        } else {//奇数
            int res = 0;
            for (int i = 1; i < nums.length; i += 2) {
                res += nums[i - 1];
                dp[i] = res;
            }
            res = 0;
            for (int i = 2; i <= nums.length; i += 2) {
                res += nums[i - 1];
                dp[i] = res;
            }
            return Math.max(dp[nums.length], dp[nums.length - 1]);

        }

    }
}
