package Array;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/5/22 上午11:47
 */

/*
例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]

 */
public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    //找到前小后大 进行交换
                    swap(nums, i, j);
                    //对交换后的进行升序排序
                    Arrays.sort(nums, i + 1, n);
                    return;
                }

            }
        }
        //找不到前小后大：返回最开头的 升序排序[1,2,3,4]
        Arrays.sort(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
