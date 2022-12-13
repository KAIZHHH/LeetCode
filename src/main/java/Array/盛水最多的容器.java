package Array;

/**
 * @author kai
 * @date 2022/4/17 下午9:22
 */
public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] height = {};
    }

    //暴力
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                res = Math.max(h * (j - i), res);
            }
        }
        return res;
    }

    //双指针
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(area, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
