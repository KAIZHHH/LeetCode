package Sort.数组.选择;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/24 下午9:46
 */
public class T2 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 19};
        System.out.println(Arrays.toString(arr));

        test(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void test(int[] arr, int low, int high) {

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }


}
