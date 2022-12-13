package Sort.数组.希尔;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/5 下午10:28
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void shellSort(int[] data) {
        int n = data.length;
        for (int increment = n / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < n; i++) {
                int temp = data[i];
                int j = 0;
                for (j = i - increment; j >= 0; j = j - increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }
}
