package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 下午1:16
 */
public class T3 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 19};
        System.out.println(Arrays.toString(arr));

        HeapSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    //堆排序
    public static void HeapSort(int[] arr, int low, int high) {
        //先建堆：最大元素已经放在在堆顶
        buildHeap(arr);
        //将堆顶 和最尾元素 交换 成功完成一个元素 的排序
        //将所有元素都交换成功后 完成堆排序！
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }

    private static void buildHeap(int[] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            //进行堆化
            heapify(arr, arr.length, i);

        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int i1 = i * 2;
        int i2 = i * 2 + 1;
        int max = i;
        if (i1 < n && arr[i1] > arr[max]) {
            max = i1;
        }
        if (i2 < n && arr[i2] > arr[max]) {
            max = i2;
        }
        if (max != i) {
            //交换一次就要重新堆化
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
