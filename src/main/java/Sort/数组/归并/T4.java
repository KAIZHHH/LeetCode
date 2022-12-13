package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 下午8:31
 */
public class T4 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        //1、判断特殊情况
        if (low >= high) {//只有一个元素
            return;
        }
        //2、求中间值
        int mid = low + (high - low) / 2;
        //3、递归分解出 两个归并段
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        //4、再合并
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        //1、记录两个归并段起始位置
        int s1 = low;
        int s2 = mid + 1;

        //2、建立临时数组
        int[] res = new int[high - low + 1];
        int start = 0;

        //3、往临时数组放入所有排序好的顺序
        while (s1 <= mid && s2 <= high) {
            //比较
            if (arr[s1] <= arr[s2]) {
                //放入
                res[start++] = arr[s1++];
            } else {
                res[start++] = arr[s2++];
            }
        }
        //4、将剩下的放入
        while (s1 <= mid) {
            res[start++] = arr[s1++];
        }
        while (s2 <= high) {
            res[start++] = arr[s2++];
        }

        //5、将临时数组赋给原数组
        for (int i = 0; i < res.length; i++) {
            arr[i + low] = res[i];
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
