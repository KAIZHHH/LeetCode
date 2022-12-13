package Array.螺旋矩阵;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/10 下午10:51
 */
/*
给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]

 */
public class 螺旋矩阵II正向 {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int num = 1, sum = n * n;

        while (num <= sum) {
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            if (t > b) break;
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            if (l > r) break;
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            if (t > b) break;
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
            if (l > r) break;
        }
        return res;
    }
}
