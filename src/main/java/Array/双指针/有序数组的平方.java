package Array.双指针;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/1 下午12:06
 */
/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(arr));
        int[] ints = sortedSquares1(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortedSquares(int[] nums) {
        //定义双指针
        int left = 0;
        int right = nums.length - 1;
        //定义新数组
        int[] result = new int[nums.length];
        int index = result.length - 1;

        while (left <= right) {
            //左边大于右边，将左边放在新数组末尾
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                //因为已经有序，考虑负数情况，比较最首最尾平方，较大的放新数组末尾
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            } else {//右边大于左边，将右边放在新数组末尾
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return result;
    }

    public static int[] sorted(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int[] nums = new int[arr.length];
        int index = arr.length - 1;

        while (left <= right) {
            if (arr[left] * arr[left] < arr[right] * arr[right]) {
                nums[index] = arr[right] * arr[right];
                index--;
                right--;
            } else {
                nums[index] = arr[left] * arr[left];
                index--;
                left++;
            }
        }
        return nums;

    }
    public static int[] sortedSquares1(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int res[]=new int[nums.length];
        int index=nums.length-1;
        while(left<=right){
            int l=nums[left]*nums[left];
            int r=nums[right]*nums[right];

            if(l<=r){
                res[index--]=r;
                right--;
            }else if(l>r){
                res[index--]=l;
                left++;
            }
        }
        return res;
    }
}

