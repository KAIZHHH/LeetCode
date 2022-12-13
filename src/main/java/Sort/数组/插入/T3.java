package Sort.数组.插入;

/**
 * @author kai
 * @date 2022/2/24 下午9:21
 */
public class T3 {
    public void test(int[] nums) {
        for (int i = 1; i < nums.length; i++) {//记录总的循环次数
            for (int j = 1; j < nums.length; j++) {//用来往前比较，插入了一共几个数就几个数比较
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }else   {//前面已经有序了 直接退出不用再比较
                    break;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
