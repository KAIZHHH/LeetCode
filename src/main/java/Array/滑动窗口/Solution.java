package Array.滑动窗口;

class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen(7, nums);
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[left];
        int min = 100;
        while (left < nums.length && right < nums.length) {
            if (sum >= target) {
                min = Math.min(right - left + 1, min);
                sum -= nums[left];
                left++;
                continue;
            } else {
                right++;
            }

            if (right >= nums.length) {
                break;
            }
            sum += nums[right];

        }
        return min;

    }
}
