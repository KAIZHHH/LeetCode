package 笔试.小红书;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/28 下午4:55
 */
/*
题目描述：
小明是一名魔法师，他会n种法术，其中第i种法术的威力为ai，他经常通过双手各自释放一种法术来提升威力，能得到的威力值为双手各自释放的法术的威力的乘积，但是他还不够强大，双手释放的两种法术必须是不同的，即不能双手释放同一种法术。这天他接到了一个任务，需要释放威力值至少为K才能完成，他想请你帮他算一算，在两只手都释放法术的情况下，共有多少方案能达到威力值K。每种方案可记作（u，v），u≠v，其威力值为au * av，（u，v）和（v，u）会被视为不同的方案。

输入描述
第一行两个正整数n和K，表示法术数量和威力值需求。

第二行为n个正整数a1, a2,...... an，其中ai表示第i个法术的威力为ai。

输出描述
输出威力值至少为K的方案数。

样例输入
3 3
3 2 1
样例输出
4
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int test = test(arr, K);
        System.out.println(test);
    }

    private static int test(int[] arr, int K) {
        int n = arr.length;
        Map<String, String> map = new IdentityHashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] * arr[j];
                if (sum >= K) {
                    map.put(new String(arr[i] + ""), new String(arr[j] + ""));

                }
            }
        }
        int size = map.size();
        int x = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue()) ) x++;
        }
        return 2 * size - x;
    }
}
