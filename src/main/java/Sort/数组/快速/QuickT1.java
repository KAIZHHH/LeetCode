package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 下午5:28
 */
public class QuickT1 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 19};
        System.out.println(Arrays.toString(arr));

        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void quick(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];//基准
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            swap(arr, i, j);

        }
        arr[low] = arr[i];
        arr[i] = temp;

        quick(arr, low, i - 1);
        quick(arr, j + 1, high);
    }
}
