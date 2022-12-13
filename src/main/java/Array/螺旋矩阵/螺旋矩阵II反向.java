package Array.螺旋矩阵;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/9/1 下午8:32
 */
//逆时针输出
public class 螺旋矩阵II反向 {
    public static void main(String[] args) {
        int[][] ints = snake_matrix(3);

        System.out.println(Arrays.deepToString(ints));

    }

    public static int[][] snake_matrix(int n) {
        int res[][] = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int num = 1, sum = n * n;

        while (num <= sum) {
            for (int i = t; i <= b; i++) res[i][l] = num++;
            l++;
            if (l > r) break;
            for (int i = l; i <= r; i++) res[b][i] = num++;
            b--;
            if (t > b) break;
            for (int i = b; i >= t; i--) res[i][r] = num++;
            r--;
            if (l > r) break;
            for (int i = r; i >= l; i--) res[t][i] = num++;
            t++;
            if (t > b) break;

        }
        return res;
    }

}
