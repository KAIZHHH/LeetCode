package Array.二分查找;

/**
 * @author kai
 * @date 2022/9/19 下午11:24
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int i = minArray(arr);
        System.out.println(i);
    }

    /*
    返回值： 当 i = j 时跳出二分循环，并返回 旋转点的值 nums[i]nums[i] 即可。
     */
    public static int minArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //第一种情况是 arr[mid] < arr[l]
            //arr[mid] 是最小值右侧的元素
            if (arr[mid] < arr[r]) {
                r = mid;// [l , mid] mid可能是最小值
                //第二种情况是 arr[mid] < arr[r]
                //arr[mid] 是最小值左侧的元素
            } else if (arr[mid] > arr[r]) {
                l = mid + 1;// [mid + 1, r]
            } else {
                r--;
            }
        }
        return arr[l];
    }
}
