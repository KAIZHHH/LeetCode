package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 上午11:39
 */
public class HeapSort1 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1, 10, 4};
        System.out.println(Arrays.toString(arr));

        heap_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heap_sort(int[] arr) {
        build_heap(arr);
        int last = arr.length - 1;
        for (int i = last; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    //建堆
    static void build_heap(int[] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, arr.length , i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        if (i > n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
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

    //交换
    static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
