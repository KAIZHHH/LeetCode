package String;

/**
 * @author kai
 * @date 2022/4/25 下午7:31
 */
/*
输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
示例 2：

输入：nums = [2,2,2,2,2]
输出：1
解释：最长连续递增序列是 [2], 长度为1。

 */
public class 最长连续递增序列_连续_个数 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int sum = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                sum++;
            } else {
                sum = 1;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
