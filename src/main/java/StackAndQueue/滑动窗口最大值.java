package StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/1/25 下午2:20
 */
/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
            -3,-1,1,3,3,5,6,7
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


/**
 * Queue 单向队列：在队尾添加元素offer()，在队首获取元素peek()、poll()
 * Deque 双向队列: 队尾队首都可以添加和获取
 * add方法	往队列尾部加入元素
 * addFirst方法	往队列首部加入元素
 * addLast方法	往队列尾部加入元素
 * getFirst方法	获取队列首部元素，但不删除
 * getLast方法	获取队列尾部元素，但不删除
 * offer方法	将指定元素插入该元素的尾部，返回true或者false，与add的区别是add当没有可用空间时会抛异常，而offer返回false
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -2, 3, 4, -3,1,3,24,5,6,13,1};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        //res数组是用来存放：几个最大值  res数组大小==有几组滑动窗口
        int[] res = new int[n - k + 1];

        //dq里面存的是：数组的index, 不是数组的值
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //清除头: 保证窗口的长度范围，当窗口长度超出，则把dq中的头部index删除
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                //i - k,因为滑动窗口长度=k=3,所以当i=3,其实是再加入第四个数时,i-k=0,dq.getFirst()=0,移除队列头部元素
                dq.removeFirst();//poll();
            }
            //清除尾: 可能前面有很多小于的都要删除  保持：头部的index是值最大nums[index]
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                //把 比 新加入的nums[index]小的 index 从dq删除 dq头部留下的是 更大的index
                dq.removeLast();
            }
            //Step3: 尾部加入, 滑动窗口向右扩充
            dq.addLast(i);
            //Step4: 头, 从头部返回极大值
            if (i + 1 >= k) {//当index+1=滑动窗口的长度时需要返回一个极大值
                //存入res中的 下标是dq里的头部
                res[i - k + 1] = nums[dq.getFirst()];//队列永远保证
            }
        }

        return res;
    }

}
