package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/8/18 下午3:13
 */
public class T7 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 4, 5, 19};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        int tem = arr[low];
        while (i < j) {
            while (i < j && tem <= arr[j]) {
                j--;
            }
            while (i < j && tem >= arr[i]) {
                i++;
            }
            swap(arr, i, j);
        }

        arr[low] = arr[i];
        arr[i] = tem;

        quickSort(arr, low, i-1);
        quickSort(arr, i + 1, high);
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
