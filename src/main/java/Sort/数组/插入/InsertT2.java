package Sort.数组.插入;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 下午4:32
 */
public class InsertT2 {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));

        insert(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }

            }

        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
