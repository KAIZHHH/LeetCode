package 笔试.Keep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kai
 * @date 2022/8/30 下午6:46
 */


public class Test3 {
    public static void main(String[] args) {
        int[][] queries = {{1, 1}, {2, 2}, {2, 3}, {0, 2}, {1, 4}, {1,5}, {0, 4}};
        int[] process = process(queries);
        System.out.println(Arrays.toString(process));
    }

    public static int[] process(int[][] queries) {
        List<Integer> list = new ArrayList();
        LinkedList<Integer> res = new LinkedList();
        for (int[] query : queries) {
            int C = query[0];
            int ID = query[1];
            if (C == 1) {
                res.addFirst(ID);
            } else if (C == 2) {
                res.addLast(ID);
            } else {
                int start = 0;
                for (int i = 0; i < res.size(); i++) {
                    if (res.get(i) == ID) {
                        start = i;
                        break;
                    }
                }
                int min = Math.min(start - 0, res.size() - 1 - start);
                list.add(min);
            }
        }
        Object[] objects = list.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            int k = (int) objects[i];
            result[i] = k;
        }
        return result;
    }
}
