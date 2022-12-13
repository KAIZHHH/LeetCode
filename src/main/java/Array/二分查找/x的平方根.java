package Array.二分查找;

class x的平方根 {
    public static void main(String[] args) {
        int i = mySqrt(8);
        System.out.println(i);
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long m = (long) mid * mid;
            if (m <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
