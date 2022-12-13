package Array.双指针;

/**
 * @author kai
 * @date 2022/4/14 下午9:24
 */
/*
[2,3,4,4,6,7,8,9,10]
5
 */
public class 最长重复子数组 {
    public static void main(String[] args) {
        int []arr={2,3,4,4,6,7,8,9,10};
        int i = maxLength(arr);
        System.out.println(i);
    }
    public static int maxLength(int[] arr) {
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < arr.length) {
            if (arr[right - 1] == arr[right] - 1) {
                max = Math.max(right - left + 1, max);
                right++;
            } else {
                max = Math.max(right - left + 1, max);
                left = right;
                right++;
            }
        }
        return max;
    }
}
