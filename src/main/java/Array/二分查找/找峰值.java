package Array.二分查找;


/*
[2,4,1,2,7,8,4]
1

4和8都是峰值元素，返回4的索引1或者8的索引5都可以
 */
public class 找峰值 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 3, 2, 7, 5};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    public static int findPeakElement(int[] nums) {
        // write code here
        //关键思想：下坡的时候可能找到波峰，但是可能找不到，一直向下走的
        //上坡的时候一定能找到波峰，因为题目给出的是nums[-1] = nums[n] = -∞
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //证明右边的路是下坡路，不一定有坡峰
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                //这里是右边的路是上坡路
                left = mid + 1;
            }
        }
        return right;
    }
}
