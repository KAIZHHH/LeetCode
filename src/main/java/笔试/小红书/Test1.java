package 笔试.小红书;

import java.util.*;

/**
 * @author kai
 * @date 2022/8/28 下午4:38
 */
/*
第一行三个正整数n、m和id，表示大臣数量、重要性方面数量和来找你帮忙的大臣序号。

接下来n行每行m个正整数，第i行为ai1, ai2,...... aim，其中aij表示序号为i的大臣的汇报在第j个方面的重要性。

输出描述
输出一行一个正整数ans，表示序号为i的大臣排在第ans位。


样例输入
3 3 2
90 90 90
80 100 90
80 85 85
样例输出
2
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int add = 0;
            for (int j = 0; j < m; j++) {
                int i1 = sc.nextInt();
                add += i1;
            }
            map.put(i + 1, add);
        }
        int test = test(map, d);
        System.out.println(test);
    }

    private static int test(Map<Integer, Integer> map, int d) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() == d) {
                return i + 1;
            }
        }
        return 0;
    }
}
