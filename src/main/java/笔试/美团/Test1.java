package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/5/14 上午10:01
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        int test = test(arr);
        System.out.println(test);
    }

    public static int test(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= target + 1 && arr[j] >= target - 1) {
                    max++;
                }
            }
            res = Math.max(res, max);
            max = 0;
        }
        return res;
    }
}
