package Greedy;

/**
 * @author kai
 * @date 2022/2/15 上午12:11
 */
/*
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

输入: nums = [2,3,0,1,4]
输出: 2
 */
public class 跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 1, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        int end = 0;        // 当前覆盖的最远距离下标

        int maxPosition = 0;

        int steps = 0;//记录操作步骤数
        for (int i = 0; i < nums.length - 1; i++) {
            //记录最大覆盖范围
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
