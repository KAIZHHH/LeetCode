package Greedy;

/**
 * @author kai
 * @date 2022/2/14 下午11:43
 */
/*
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;//已经到达最后一个下标了
        //确定初始覆盖范围
        int coverRange = nums[0];
        //在覆盖范围内 遍历有没有更大的coverRange能到达
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);////当前覆盖距离cover、当前位置+能跳跃的距离 取max
            if (coverRange >= n - 1) {//比较下标索引
                return true;
            }
        }
        return false;
    }
}
