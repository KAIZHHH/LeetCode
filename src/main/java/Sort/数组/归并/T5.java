package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/26 下午9:40
 */
public class T5 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int[] res = new int[high-low+1];
        int start = 0;
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] < arr[s2]) {
                res[start++] = arr[s1++];
            } else {
                res[start++] = arr[s2++];
            }

        }
        while (s1 <= mid) {
            res[start++] = arr[s1++];
        }
        while (s2 <= high) {
            res[start++] = arr[s2++];
        }
        for (int i = 0; i < res.length; i++) {
            arr[i + low] = res[i];
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}

