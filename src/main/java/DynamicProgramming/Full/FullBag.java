package DynamicProgramming.Full;

/**
 * @author kai
 * @date 2022/2/22 下午2:32
 */
public class FullBag {


    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testCompletePack(weight, value, bagWeight);
    }

    //先遍历物品，再遍历背包
    private static void testCompletePack(int[] weight, int[] value, int bagWeight) {

        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weight.length; i++) { // 遍历物品
//            for (int j = bagWeight; j >=weight[i]; j--){ :01背包
//             dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i])
            for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int maxValue : dp) {
            System.out.println(maxValue + "   ");
        }
    }
}
