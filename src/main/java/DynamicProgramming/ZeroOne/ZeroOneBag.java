package DynamicProgramming.ZeroOne;

/**
 * @author kai
 * @date 2022/2/21 下午2:00
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagweight = 4;
        int i = testTwo(weight, value, bagweight);
        System.out.println(i);
    }

    //二维数组dp[][]
    public static int testTwo(int[] weight, int[] value, int bagweight) {
        //定义dp数组：dp[i][j]表示：可以选择前i个物品0-i 当背包容量为j  能获得的最大价值
        int[][] dp = new int[value.length + 1][bagweight + 1];//+1是为了 i=0 j=0 这种默认的最大价值为0 但是得有 因为计算需要前者
        //遍历顺序：先遍历物品，再遍历背包容量(可颠倒)
        //从i=1 j=1开始 因为i=0 j=0 的价值都为0
        for (int i = 1; i < weight.length + 1; i++) {//1个物品可以选择开始遍历从小到大的背包容量 计算最大价值
            for (int j = 1; j < bagweight + 1; j++) {
                //i=物品 可以选择前一个物品 前两个物品 前三个物品 i=0没有物品可以放
                //对于weight[0] value[0] 代表的就是第一个物品
                if (j < weight[i - 1]) {//背包容量为j 不够放
                    dp[i][j] = dp[i - 1][j];//不够放那就不放 默认减掉那个物品 i-1
                } else {//背包容量为j 不够放
                    /*放物品i的最大价值==还没放物品i前的最大价值+物品i的价值
                    不放物品i的最大价值==已知一定不放的最大价值
                    比较 取最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[value.length][bagweight];
        //打印dp数组
//        for (int i = 0; i < weight.length + 1; i++) {
//            for (int j = 0; j < bagweight + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
    }

    //一维数组滚动数组
    public static void testOne(int[] weight, int[] value, int bagWeight) {

        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];

        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            //倒序遍历：保证每个物品只被添加一次 dp[j]默认为0
            for (int j = bagWeight; j >= weight[i]; j--) {
                /*不放物品i的最大价值==把容量j都放满的价值dp[j]
                  放物品i的最大价值==还没放物品i前的最大价值【容量j-物品i的容量】+物品i的价值
                  比较 取最大
                */
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }


    }

}
