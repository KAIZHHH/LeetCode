package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/27 下午7:57
 */
public class T5 {
    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 19};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];
        while (i < j) {

            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            swap(arr, i, j);
        }
        //i==j
        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
