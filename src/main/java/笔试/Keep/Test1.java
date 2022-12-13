package 笔试.Keep;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] timeToBed = {23, 35};
        int[][] alarms = {{20, 15}, {10, 30}};
        int[] ints = sleepTime(timeToBed, alarms);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sleepTime(int[] timeToBed, int[][] alarms) {
        int h = timeToBed[0];
        int m = timeToBed[1];
        int sum = h * 60 + m;
        int diff = Integer.MAX_VALUE;
        for (int[] alarm : alarms) {
            int h1 = alarm[0];
            int m1 = alarm[1];
            int sum1 = h1 * 60 + m1;
            if (sum < sum1) {
                int len = sum1 - sum;
                diff = Math.min(len, diff);
            } else if (sum > sum1) {
                int len = 24 * 60 - sum + sum1;
                diff = Math.min(len, diff);
            } else {
                return new int[]{0, 0};
            }
        }
        int resh = diff / 60;
        int minh = diff % 60;
        return new int[]{resh, minh};
    }
}
