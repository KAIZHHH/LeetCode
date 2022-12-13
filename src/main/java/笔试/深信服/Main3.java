package 笔试.深信服;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/6/7 下午8:42
 */
/*
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

求梯形面积：(上底+下底)*高/2
 */
public class Main3 {
    public static void main(String[] args) {
        int[] height1 = {2};
//2 3   5   7   9
        int i = histogram_max_area(height1);
        System.out.println(i);
    }

    public static int histogram_max_area(int[] histogram) {
        int res = 0;
        Arrays.sort(histogram);
        int n = histogram.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            area = histogram[i] * (n - i );
            res = Math.max(area, res);
        }
        return res;
    }
}
