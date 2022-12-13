package Sort.数组.插入;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 上午11:19
 */
public class T4 {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));
        insert(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {//这层for循环 每次遍历都需要找到一个最小的 放到数组最前
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
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
