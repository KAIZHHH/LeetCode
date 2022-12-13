package technology;

import org.junit.Test;

import java.util.*;

/**
 * @author kai
 * @date 2022/8/3 下午11:57
 */
public class 遍历集合 {

    public static void test() {

    }

    @Test
    //遍历set
    public void test1() {
        Set<String> set = new HashSet<>();
        set.add("Aa");
        set.add("Aa");
        set.add("Bb");
        set.add("Cc");

        //方法1 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        Iterator it1 = set.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        //方法2 增强型for循环遍历
        for (String value : set) {
            System.out.println(value);
        }
    }

    @Test
    //遍历list
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        //方法1
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //方法2
        for (int num : list) {
            System.out.println(num);
        }

    }

    @Test
    //遍历map
    public void test3() {
        Map<Integer, Integer> map = new HashMap();
        map.put(1, 3);
        map.put(3, 2);
        map.put(2, 1);

        //遍历map 转二维数组
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (int i : map.keySet()) {
            res[index][0] = i;
            res[index++][1] = map.get(i);
        }
    }
}
