package 笔试.京东;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/27 下午7:48
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = test(arr, n);
        System.out.println(res);
    }

    private static int test(int[] arr, int n) {
        int newArr[] = arr.clone();

        int resA = 0;
        int temp = 1;
        while (temp < n - 1) {
            if (newArr[temp - 1] != newArr[temp + 1]) {
                newArr[temp + 1] = newArr[temp - 1];
                resA++;
            }
            temp++;
        }
        newArr = arr.clone();

        int resB = 0;
        temp = n - 2;
        while (temp > 0) {
            if (newArr[temp - 1] != newArr[temp + 1]) {
                newArr[temp - 1] = newArr[temp + 1];
                resB++;
            }
            temp--;
        }

        int res = Math.min(resA, resB);
        return res;

    }

}
