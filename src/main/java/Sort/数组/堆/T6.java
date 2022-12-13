package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/7/10 下午11:16
 */
public class T6 {
    //建堆：小三角进行堆化 首结点为max元素 交换到最后
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //建堆 首结点为max元素
        buildHeap(arr);
        //交换
        for (int i = arr.length - 1; i >= 0; i--) {
            //每交换完 都要进行堆化
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    //建堆:从最后一个结点进行小三角的 堆化
    public static void buildHeap(int[] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        int n = arr.length;

        //堆化
        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    //堆化
    public static void heapify(int[] arr, int n, int parent) {
        int c1 = parent * 2;
        int c2 = parent * 2 + 1;
        int max = parent;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != parent) {
            //每交换完 都要进行堆化
            swap(arr, max, parent);
            heapify(arr, n, max);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
