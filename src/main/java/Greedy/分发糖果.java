package Greedy;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/16 上午12:44
 */
//https://www.bilibili.com/video/BV1ST4y1X7dp?spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=a81474b1b4d906df3173891054419ef2
/*
整数数组 ratings 表示每个孩子的评分
每个孩子至少分配到 1 个糖果
相邻之间 评分高的 获得更多糖果
返回需要准备的 最少糖果数目

输入：ratings = [1,0,2]
输出：5
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。

输入：ratings = [1,2,2]
输出：4
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class 分发糖果 {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        int candy = candy(ratings);
        System.out.println(candy);
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
