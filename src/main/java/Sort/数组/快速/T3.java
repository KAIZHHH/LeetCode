package Sort.数组.快速;

/**
 * @author kai
 * @date 2022/3/8 下午2:35
 */
public class T3 {
    public void quick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = nums[left];

        while (i < j) {
            while (i < j && nums[left] <= temp) {
                left++;
            }
            while (i < j && nums[right] >= temp) {
                right--;
            }
            swap(nums, left, right);
        }
        //i==j
        nums[left] = nums[i];
        nums[i] =temp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
