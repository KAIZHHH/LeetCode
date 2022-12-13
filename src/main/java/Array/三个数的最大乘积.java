package Array;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/7/26 下午2:46
 */
public class 三个数的最大乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 4, -2, 5, -8, 5, 2};
        int i = maximumProduct(nums);
        System.out.println(i);
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
