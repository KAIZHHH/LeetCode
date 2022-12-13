package Sort.数组.冒泡;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 下午4:12
 */

public class BubbleT2 {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }


    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
