package 笔试.三六零;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int test = test(N, M, arr);
        System.out.println(test);
    }

    private static int test(int n, int m, int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        int couple = n - m;
        int max = 0;
        for (int j = 1, k = 2 * couple - 1; j <= couple; j++, k--) {
            res = arr[j - 1] + arr[k];
            if (max < res) {
                max = res;
            }
        }
        return max;
    }

}


