package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/5 下午3:02
 * 快速排序
 */
/*
快速排序 数组为有序则是最坏时间复杂度 O(n*n)
        数组长度每次划分为一半为最好时间复杂度 O(n*log2为底n的对数)

 */
public class  QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 4, 5, 19};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        //temp就是基准位
        int temp = arr[low];

        while (i < j) {
            //正常情况是temp更小 所以往左递减j--
            //遇到比temp大 就退出 进行交换
            while (i < j && arr[j] >= temp) {
                j--;//需要找到比temp小的才好交换
            }
            //正常情况是temp更大 所以往左递减j--
            //遇到比temp小 就退出 进行交换
            while (i < j && arr[i] <= temp) {
                i++;
            }

            swap(arr, j, i);

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        quickSort(arr, low, i - 1);
        //递归调用右半数组
        quickSort(arr, i + 1, high);
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
