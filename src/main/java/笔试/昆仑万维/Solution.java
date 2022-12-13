package 笔试.昆仑万维;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 2, 2, 2};
        int i = MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            Object value = next.getValue();
            int k = (int) value;
            if (k > n / 2) {
                return (int) next.getKey();
            }
        }
        return 0;
    }
}
