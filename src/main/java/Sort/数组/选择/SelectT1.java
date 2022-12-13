package Sort.数组.选择;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 下午4:19
 */
public class SelectT1 {
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(arr));

        select(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minindex] > arr[j]) {
                    minindex = j;
                }
            }
            swap(arr, minindex, i);

        }
    }
}
