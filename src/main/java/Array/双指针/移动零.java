package Array.双指针;

/**
 * @author kai
 * @date 2021/12/31 下午2:31
 */
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
同时保持非零元素的相对顺序。

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

 */
public class 移动零 {
    public static void main(String[] args) {
        int nums[] = {0, 0, 0, 0, 4, 5};
        moveZeroes2(nums);
    }

    //双指针：填充0
    public static void moveZeroes(int[] nums) {
        int p = 0;
        int q = 0;
        while (p < nums.length) {
            if (nums[p] != 0) {
                nums[q] = nums[p];
                p++;
                q++;
            } else {
                p++;
            }
        }
        for (int i = q; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //双指针：记录为0的下标地址和非0交换
    public static void moveZeroes2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                //把0往后换
                swap(nums, left, right);
                left++;
                right++;
            } else {
                right++;
            }
        }

    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
