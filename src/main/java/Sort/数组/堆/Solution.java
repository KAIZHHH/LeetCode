package Sort.数组.堆;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        sortColors(nums);
        System.out.println(nums);
    }

    public static void sortColors(int[] nums) {
        heapSort(nums);
    }

    public static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    public static void buildHeap(int[] nums) {
        int last = nums.length - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    public static void heapify(int[] nums, int n, int parent) {
        int c1 = parent * 2 + 1;
        int c2 = parent * 2 + 2;
        int max = parent;
        if (nums[max] < nums[c1]) {
            max = c1;
        }
        if (nums[max] < nums[c2]) {
            max = c2;
        }
        if (max != parent) {
            swap(nums, max, parent);
            heapify(nums, n, max);
        }
    }


    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
