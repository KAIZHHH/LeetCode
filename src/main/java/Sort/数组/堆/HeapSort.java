package Sort.数组.堆;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/8 上午12:45
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        return nums[nums.length - k];
    }

    /**
     * 1、先建堆 ：进行堆化(成功后 最大元素放在在堆顶)
     * 2、将堆顶 和最尾元素 交换 成功 确定：一个元素的排序
     * 3、再进行堆化(成功后 最大元素放在在堆顶)
     * 4、所有元素都确定后：完成堆排序
     */
    public static void heapSort(int[] arr) {
        //先建堆
        buildHeap(arr);
        //建堆后，首结点为排好序的  最大的结点  再和 最末尾结点  交换
        for (int i = arr.length - 1; i >= 0; i--) {
            //每交换完一次也要进行 对后面进行 堆排序
            //将首尾结点交换
            swap(arr, i, 0);
            //交换完，传入i是 剩下未进行排序的长度，0是需要堆化的起点 因为刚交换完需要从上往下继续换
            heapify(arr, i, 0);

        }
    }

    //建堆：从最后一个节点的父节点开始向上 堆排序
    public static void buildHeap(int[] arr) {
        int last = arr.length - 1;
        int parent = (last - 1) / 2;
        int n = arr.length;
        //从parent结点开始 对每个小三角进行堆化排序
        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);

        }
    }


    /**
     * @param arr
     * @param n：数组的长度
     * @param i：堆化的起点
     */
    //堆排序：对二叉树的小三角进行 大的在上 小的在下
    public static void heapify(int[] arr, int n, int i) {
        //两个子节点
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        //假设定义最大的为i
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }

        //一开始定义的max为i，判断如果不是为i则说明比较的最大值下标更改了,进行swap交换
        // 每交换一次都需要进行heapfiy重新堆排序
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, n, max);
        }

    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
