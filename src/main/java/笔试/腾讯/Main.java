package 笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.valueOf(s1);
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        int[][] array = twoArray(str);
        int[] res = new int[array[0].length];
        StringBuilder sb;
        for (int j = 0; j < array[0].length; j++) {
            sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i][j]);
            }
            res[j] = Integer.valueOf(sb.toString());
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");

        }
    }

    public static int[][] twoArray(String[] str) {
        int[][] array = new int[str.length][str[0].length()];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length(); j++) {
                array[i][j] = Integer.valueOf(str[i].charAt(j) - '0');
            }
        }
        return array;
    }
}
