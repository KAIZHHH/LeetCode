package 笔试.滴滴;

/**
 * @author kai
 * @date 2022/6/12 上午10:48
 */
public class T1 {
    public static void main(String[] args) {
        int[] values = {1, 3, 4, 2, 1, 5};
        boolean illegal = isIllegal(values);
        System.out.println(illegal);
    }

    public static boolean isIllegal(int[] values) {
        // 让第一个数字为降序或者升序的一部分，进行dfs搜索
        boolean asc = dfs(values, 1, values[0], Integer.MAX_VALUE);
        boolean desc = dfs(values, 1, Integer.MIN_VALUE, values[0]);
        return asc || desc;
    }

    /**
     * @param values
     * @param index     当前搜索的数字
     * @param preLower  升序序列的末尾
     * @param preHigher 降序序列的末尾
     */
    public static boolean dfs(int[] values, int index, int preLower, int preHigher) {
        if (index >= values.length) return true;
        // values[index] 作为升序序列的一部分
        if (values[index] > preLower && dfs(values, index + 1, values[index], preHigher)) {
            return true;
        }
        // values[index] 作为降序序列的一部分
        if (values[index] < preHigher && dfs(values, index + 1, preLower, values[index])) {
            return true;
        }
        // 都不行，返回false
        return false;
    }
}
