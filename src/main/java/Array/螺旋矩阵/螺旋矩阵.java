package Array.螺旋矩阵;


import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/1/10 下午11:19
 */
/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1, sum = matrix.length * matrix[0].length;
        while (sum >= 1) {
            for (int i = l; i <= r && sum >= 1; i++) {
                res.add(matrix[t][i]);
                sum--;
            }
            t++;
            for (int i = t; i <= b && sum >= 1; i++) {
                res.add(matrix[i][r]);
                sum--;
            }
            r--;
            for (int i = r; i >= l && sum >= 1; i--) {
                res.add(matrix[b][i]);
                sum--;
            }
            b--;
            for (int i = b; i >= t && sum >= 1; i--) {
                res.add(matrix[i][l]);
                sum--;
            }
            l++;
        }
        return res;
    }


}
