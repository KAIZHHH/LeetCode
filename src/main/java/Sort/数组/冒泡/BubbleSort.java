package Sort.数组.冒泡;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/3 下午7:52
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));

        bubbleSort1(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }


    public static void bubbleSort1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {//有几个数就遍历几次 每一层i遍历结束 都会把最大的数放数组最后 下次一层i就不比较最后 少比较一次
            for (int j = 1; j < n-i-1; j++) {//每一层i遍历 都会将
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    //如果右边元素都大于左边，意思是已经是排序好
    public void bubbleSort2(int[] nums) {
        int n = nums.length;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }
            }
            if (flag == false) {//说明没有交换，则表明[0,len-i-1]已经是有序的了
                break;
            }
        }
    }

}
