package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 下午1:48
 */
public class T3 {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    public static void merge(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;

        merge(arr, low, mid);
        merge(arr, mid + 1, high);
        mergeSort(arr, low, mid, high);

    }

    private static void mergeSort(int[] arr, int low, int mid, int high) {
        //1、记录起始点
        int s1 = low;
        int s2 = mid + 1;
        int[] res = new int[high - low + 1];
        int begin = 0;
        //2、进行比较 小的放进 临时数组
        while (s1 <= mid && s2 <= high) {
            if (arr[s1] >=arr[s2]) {
                res[begin++] = arr[s2++];
            } else {
                res[begin++] = arr[s1++];

            }
        }
        while (s1 <= mid) {
            res[begin++] = arr[s1++];
        }
        while (s2 <= high) {
            res[begin++] = arr[s2++];
        }

        //3、将临时数组拷贝到大数组
        for (int j = 0; j < res.length; j++) {
            arr[j + low] = res[j];

        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
