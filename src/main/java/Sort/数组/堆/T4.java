package Sort.数组.堆;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/3/19 下午8:19
 */
public class T4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void HeapSort(int[] arr) {
        //建堆
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }

    public static void buildHeap(int[] arr) {
        int last = arr.length - 1;
        int parent = last - 1 / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int i1 = i * 2 + 2;
        int i2 = i * 2 + 1;
        int max = i;
        if (i1 < n && arr[i1] > arr[max]) {
            max = i1;
        }
        if (i2 < n && arr[i2] > arr[max]) {
            max = i2;
        }
        if (max != i) {
            swap(arr, max, i);
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
