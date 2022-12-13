package Sort.数组.选择;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/3 下午8:57
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {5,2,3,1};
        System.out.println(Arrays.toString(arr));

        SelectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    //往下扫描扫到最小的往前面放arr[0]
    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;//循环一圈确定最小值的下标再进行交换
                }

            }
            swap(arr, minIndex, i);
        }
    }

    public static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }

            }
            swap(arr, minIndex, i);

        }
    }

}
