package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/7/11 下午2:40
 */
public class T6 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;//只有一个元素
        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int s1 = l;
        int s2 = mid + 1;
        int[] res = new int[r - l + 1];
        int start = 0;
        while (s1 <= mid && s2 <= r) {
            if (arr[s1] <= arr[s2]) {
                res[start++] = arr[s1++];
            } else {
                res[start++] = arr[s2++];

            }
        }
        while (s1 <= mid) {
            res[start++] = arr[s1++];
        }
        while (s2 <= r) {
            res[start++] = arr[s2++];
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j + l] = res[j];

        }
    }
}
