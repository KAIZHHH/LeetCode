package 笔试.数字马力;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/10/15 下午6:39
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int test = test(arr, n);
        System.out.println(test);
    }

    public static int test(int[] A, int n) {
        if (n > 500) return -1;
        if (n <= 0) return 0;
        int sum = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] <= A[n - 1])
                sum += A[i];
        }

        return sum + test(A, n - 1);
    }
};
