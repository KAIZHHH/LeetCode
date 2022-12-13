package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/3/19 上午11:31
 */
public class T4 {

    public static void main(String[] args) {

        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));

        quick(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    public static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            //一定要先找出后面的
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            swap(arr, i, j);
        }
        //i==j退出
        arr[left] = arr[i];
        arr[i] = temp;
        quick(arr, left, i - 1);
        quick(arr, i + 1, right);

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
