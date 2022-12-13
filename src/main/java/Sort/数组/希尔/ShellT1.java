package Sort.数组.希尔;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/12 下午6:16
 */
public class ShellT1 {
    public static void main(String[] args) {
        int[] arr = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        System.out.println(Arrays.toString(arr));

        shell(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shell(int[] arr) {
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                int temp = arr[i];
                int j = 0;
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;

                    }

                }
                arr[j + increment] = temp;
            }

        }
    }
}
