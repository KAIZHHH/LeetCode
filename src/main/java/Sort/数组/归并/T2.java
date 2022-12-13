package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/26 上午11:24
 */
public class T2 {
    public static void main(String[] args) {
        int[] arr = {34, 25, 8, 734, 1, 90, 7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        //标记 归并段 起始下标 进行比较
        int s1 = low;
        int s2 = mid + 1;
        int[] temp = new int[high - low + 1];//定义临时数组
        int start = 0;
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] < arr[s2]) {
                temp[start++] = arr[s1++];//把小的放进去
            } else {//arr[s1] > arr[s2]
                temp[start++] = arr[s2++];//把小的放进去
            }
        }
        while (s1 <= mid) {
            temp[start++] = arr[s1++];
        }
        while (s2 <= high) {
            temp[start++] = arr[s2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + low] = temp[i];
        }
    }
}
