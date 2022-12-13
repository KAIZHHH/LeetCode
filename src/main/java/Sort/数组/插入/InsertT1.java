package Sort.数组.插入;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/9 下午11:41
 */
public class InsertT1 {
    public static void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {

                if (arr[j]<arr[j-1]){

                }
            }

        }
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        BubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
