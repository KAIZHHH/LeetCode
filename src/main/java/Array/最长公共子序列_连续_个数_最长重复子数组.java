package Array;

/*
输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。

输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
输出：5
 */
class 最长公共子序列_连续_个数_最长重复子数组 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        int length = findLength(nums1, nums2);
        System.out.println(length);
    }

    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j]表示A的前i项与B的前j项的最长重复子数组长度
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
