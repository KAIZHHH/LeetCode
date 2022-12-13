package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/26 下午9:27
 */
public class T5 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void HeapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        int last = arr.length - 1;
        int parent = last - 1 / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, n, max);
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
