package LeetCodeHot100;

/*
输入：
[3,1,2,5,2,4]
返回值：5

数组 [3,1,2,5,2,4] 表示柱子高度图，在这种情况下，可以接 5个单位的雨水，蓝色的为雨水 ，如题面图。

输入：
[4,5,1,3,2]
返回值：
2
 */

public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {2, 4, 0, 3, 2, 5};
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {2, 9, 5, 7, 3};
        int i = trap(height2);
        System.out.println(i);
    }


    /*思路：
    定义左数组：从左往右扫描：存储max的元素
    定义右数组：从右往左扫描：存储max的元素
    再从头遍历到尾 比较左右数组left[i] right[i] 取更小的高度 才能装水
     */
    public static int trap(int[] height) {
        int len = height.length;
        int left[] = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        int right[] = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(left[i], right[i]);
            res += min - height[i];
        }
        return res;

    }

}

