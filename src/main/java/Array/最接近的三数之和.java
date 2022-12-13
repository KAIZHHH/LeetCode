package Array;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/8/17 下午6:41
 */
/*
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

输入：nums = [0,0,0], target = 1
输出：0
 */
public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int i = threeSumClosest(nums, 1);
        System.out.println(i);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];//初始
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                //如果sum的更大 差就更小  ans=res
                if (Math.abs(target - sum) < Math.abs(target - ans)) ans = sum;
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}

