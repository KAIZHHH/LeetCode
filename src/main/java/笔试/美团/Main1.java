package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/13 下午5:12
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int t = Integer.valueOf(s[1]);
        String[] s1 = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }
        int max = test(arr, t);
        System.out.println(n - max);

    }


    private static int test(int[] arr, int t) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] k = new int[n];
        Arrays.fill(k, 0);
        int max = arr[n - 1];
        int time = 0;
        if (max % t == 0) {
            time = max / t;
        } else {
            time = max / t + 1;
        }
        int res = 0;
        for (int j = 1; j <= time; j++) {
            for (int i = 0; i < n; i++) {
                if (arr[i] >= t) {
                    k[i] = k[i] + 1;
                    arr[i] = arr[i] - t;
                }
                res = Math.max(k[i], res);
            }
        }
        return res;

    }
}
