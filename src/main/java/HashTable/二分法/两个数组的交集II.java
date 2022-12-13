package HashTable.二分法;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/19 上午12:37
 */
/*
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集，重复的也算
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

 */
public class 两个数组的交集II {
    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};

        intersect(num1, num2);

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;
        int[] res = new int[Math.min(len1, len2)];//res数组长度是 len1和len2最小值
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index] = nums1[index1];
                index1++;
                index2++;
                index++;

            }
        }
        return Arrays.copyOfRange(res, 0, index);//返回res数组从[0,index)


    }
}
