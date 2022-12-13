package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/9 下午8:22
 * 重写归并排序
 */
public class MergeT1 {
    public static void main(String[] args) {
        int[] arr = {34, 25, 8, 734, 1, 90, 7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {//height一定要大于low 就是至少两个数排序
            return;
        }
        int mid = (high + low) / 2;// /2
        //递归分解
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        //合并
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int height) {
        //两个归并段的起始下标
        int s1 = low;
        int s2 = mid + 1;
        //临时数组
        int[] temp = new int[height - low + 1];
        int i = 0;//记录临时数组的起始下标

        while (s1 <= mid && s2 <= height) {
            //小的放入临时数组
            if (arr[s1] < arr[s2]) {
                temp[i++] = arr[s1++];
            } else {//arr[s1] > arr[s2]
                temp[i++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            temp[i++] = arr[s1++];
        }
        while (s2 <= height) {
            temp[i++] = arr[s2++];
        }
        //将临时数组拷贝到大数组
        for (int j = 0; j < temp.length; j++) {
            arr[j + low] = temp[j];
        }
    }
}
