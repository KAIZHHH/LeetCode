package 笔试.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/4 下午7:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long k = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int test = test(arr, n, k);
        System.out.println(test);
    }

    private static int test(int[] arr, int n, Long k) {
        Arrays.sort(arr);
        for (int i = n; i >= 0; i--) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            double res = sum / n;
            int max = arr[i - 1];
            if (res * k > max) {
                return i;
            }
        }
        return -1;
    }
}
