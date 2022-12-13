package Array.二分查找;

import java.util.Scanner;

/*
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A = {1, 3, 5, 7, 9};
        int val = scan.nextInt();
        int pos = getPos(A, val);
        System.out.println(pos);

    }

    public static int getPos(int[] A, int val) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (val > A[mid]) {
                left = mid + 1;
            } else if (val < A[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
