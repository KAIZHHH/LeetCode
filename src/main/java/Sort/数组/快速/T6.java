package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/7/10 下午11:16
 */
public class T6 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        //设置基准
        int temp = nums[low];

        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            swap(nums, i, j);
        }
        //退出while循环：此时i==j   将基准与i==j的数字 进行交换
        nums[low] = nums[i];
        nums[i] = temp;

        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
