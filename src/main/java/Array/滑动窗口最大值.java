package Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/5/23 上午11:39
 */
/*
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow1(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int l = 0;
        int r = k - 1;
        while (r < n) {
            int i = smax(nums, l, r);
            res[l] = i;
            l++;
            r++;
        }
        return res;
    }

    public static int smax(int[] nums, int l, int r) {
        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }


    public static int[] maxSlidingWindow1(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();//保存在滑动窗口范围内 元素从大到小 的下标
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            //清除头：如果
            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            //清除尾： 如果加入进来的元素 nums[i] 比 队列中保存的最大元素 的下标 还要大 则把队列 大下标删掉 把 更大添加进来
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            //添加元素
            dq.addLast(i);

            if (i + 1 >= k) {
                //dq.getFirst()一定是最大的下标
                res[i + 1 - k] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
