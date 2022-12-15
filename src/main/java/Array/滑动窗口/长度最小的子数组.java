package Array.滑动窗口;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/10 下午5:33
 */
/*
给定一个含有 n 个正整数的数组和一个正整数 s ，
找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
如果不存在符合条件的子数组，返回 0。
输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3, 7};
        System.out.println(Arrays.toString(arr));
        int i = minSubArrayLen(7, arr);
        System.out.println(i);
    }

    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        //遍历每个数字
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //1、首先：sum必须达到s值
            //2、再取长度最小
            while (sum >= s) {
                result = Math.max(result, right - left + 1);
                //试着减掉最开始的 再进行比较
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //方法二：前缀和 + 二分查找
    /*
    时间复杂度：O(nlogn)，其中 nn 是数组的长度。需要遍历每个下标作为子数组的开始下标，遍历的时间复杂度是 O(n)，对于每个开始下标，需要通过二分查找得到长度最小的子数组，二分查找得时间复杂度是 O(\log n)O(logn)，因此总时间复杂度是 O(n \log n)O(nlogn)。
    空间复杂度：O(n)，其中 nn 是数组的长度。额外创建数组 sums 存储前缀和。
     */
    public int minSubArrayLen1(int t, int[] nums) {
        int n = nums.length, ans = n + 10;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int s = sum[i], d = s - t;
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sum[mid] <= d) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (sum[r] <= d) {
                ans = Math.min(ans, i - r);
            }
        }
        return ans == n + 10 ? 0 : ans;
    }
}
