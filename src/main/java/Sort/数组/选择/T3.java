package Sort.数组.选择;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 上午11:14
 */
public class T3 {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));
        select(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//遍历所有找到最小的放前面
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
