package LeetCodeHot100;

/**
 * @author kai
 * @date 2022/6/24 上午12:19
 */
public class _4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length - 1;
        int n = nums2.length - 1;
        int k = m + n + 1;
        int[] num = new int[k + 1];
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                num[k--] = nums1[m--];
            } else {
                num[k--] = nums2[n--];
            }
        }
        while (m >= 0) {
            num[k--] = nums1[m--];
        }
        while (n >= 0) {
            num[k--] = nums2[n--];
        }
        double res = 0;
        int len = num.length;
        int mid = len / 2;

        if (len % 2 != 0) {//奇数
            res = num[mid];
        } else {//偶数
            res = (num[mid] + num[mid - 1]) / 2.0;
        }
        return res;
    }
}
