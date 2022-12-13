package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/8/18 下午2:58
 */
public class T7 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
//        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int last = arr.length - 1;
        for (int i = last; i >= last - 2; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }

    }

    private static void buildHeap(int[] arr) {
        int n = arr.length;
        int last = arr.length - 1;
        int dad = last - 1 / 2;
        for (int i = dad; i >= 0; i--) {
            heapify(arr, i, n);
        }

    }

    private static void heapify(int[] arr, int i, int n) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int min = i;
        if (c1 < n && arr[min] > arr[c1]) {
            min = c1;
        }
        if (c2 < n && arr[min] > arr[c2]) {
            min = c2;
        }
        if (min != i) {
            swap(arr, min, i);
            heapify(arr, min, n);
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
