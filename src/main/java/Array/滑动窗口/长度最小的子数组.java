package Array.滑动窗口;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/10 下午5:33
 */
/*
给定一个含有 n 个正整数的数组和一个正整数 s ，
找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
如果不存在符合条件的子数组，返回 0。
输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3, 7};
        System.out.println(Arrays.toString(arr));
        int i = minSubArrayLen(7, arr);
        System.out.println(i);
    }

    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        //遍历每个数字
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //1、首先：sum必须达到s值
            //2、再取长度最小
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                //试着减掉最开始的 再进行比较
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
