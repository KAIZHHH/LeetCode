package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/21 下午6:22
 */
/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6};
        boolean b = canPartitionOne(nums);
        System.out.println(b);
    }

    public static boolean canPartitionOne(int[] nums) {
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果是奇数，直接返回 false
        if ((sum % 2) != 0) {
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);

            }

        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
//                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
//            }
//        }

        return dp[target] == target;

    }


    public boolean canPartitionTwo(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果是奇数，直接返回 false
        if ((sum % 2) != 0) {
            return false;
        }
        /**
         * 总共有target容量：需要装weight[i]
         * int nums[]=int weight[]=int value[]={1,2,3,6}
         * 转成01背包问题：
         * weight=nums.length
         * bagweight=target
         */
        int target = sum / 2;
        //dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
        int[][] dp = new int[nums.length + 1][target + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {

                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);

                }
            }
        }

        return dp[nums.length][target] == target;
    }

}

