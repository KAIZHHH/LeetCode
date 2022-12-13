package 笔试.微众银行;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/13 下午8:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int test = test(s);
        System.out.println(test);
    }

    private static int test(String[] arr) {
        int n = arr.length;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (arr[j].charAt(0) - '0' > arr[j + 1].charAt(0) - '0') {
                    swap(arr, j, j + 1);
                }
            }
        }
        for (int i = n - 1; i >= n - 2; i--) {
            sb.append(arr[i]);
        }
        int[] res = new int[n - 3];
        int max = Integer.parseInt(arr[0]);
        for (int i = 1; i < n - 3; i++) {
            if (max < Integer.parseInt(arr[i])) {
                max = Integer.parseInt(arr[i]);
            }
        }
        sb.append(max + "");

        String s = new String(sb);

        return Integer.parseInt(s);
    }

    private static void swap(String[] arr, int j, int i) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
