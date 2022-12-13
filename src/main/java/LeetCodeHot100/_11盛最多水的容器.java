package LeetCodeHot100;

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
public class _11盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height1 = {2,9,5 ,7,3};

        int i = maxArea(height);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            //          高   *   取小的底边
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);

            if (height[i] < height[j]) {//j的已经比i大了 移动i 找到相对大的
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
