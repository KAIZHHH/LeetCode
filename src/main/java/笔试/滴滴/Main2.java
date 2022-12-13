package 笔试.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/4 下午8:04
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = start[i];
            matrix[i][1] = end[i];
        }
        List<Integer> test = test(matrix, target);
        for (int i : test) {
            System.out.print(i + " ");

        }
    }

    private static List<Integer> test(int[][] matrix, int[] target) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = matrix[i][0]; j <= matrix[i][1]; j++) {
                if (isValid(j) == target[i]) {
                    sum++;
                }
            }
            list.add(sum);
        }
        return list;
    }

    private static int isValid(int j) {
        String s = j + "";
        int sum = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            sum ^= s.charAt(i) - '0';
        }
        return sum;
    }
}
