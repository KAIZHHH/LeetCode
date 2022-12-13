package Sort.数组.冒泡;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/24 下午9:14
 */
public class T3 {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//遍历交换的次数：几个数字就几次
            for (int j = 0; j < nums.length - i-1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
