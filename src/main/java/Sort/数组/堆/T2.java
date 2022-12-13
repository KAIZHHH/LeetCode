package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/26 下午2:15
 */
public class T2 {

    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void heapSort(int[] arr) {
        buildheap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    //建堆
    public static void buildheap(int[] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

    }

    //堆排序
    private static void heapify(int[] arr, int n, int i) {
        if (i >= n) return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        //进行比较交换
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != i) {//最大值改变了
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
