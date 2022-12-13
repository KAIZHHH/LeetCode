package technology;

import org.junit.Test;

import java.util.*;

/**
 * @author kai
 * @date 2022/8/23 上午12:45
 */
public class 排序Map {
    @Test
    public void test1() {
        // 初始数据
        Map<Character, Integer> smap = new HashMap<>();
        smap.put('b', 11);
        smap.put('a', 33);
        smap.put('c', 22);

        System.out.println("----------根据key排序 升序------------------");

        // 1.8以前
        List<Map.Entry<Character, Integer>> list1 = new ArrayList<>();
        list1.addAll(smap.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Character, Integer> entry : list1) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        System.out.println("----------根据value排序 升序------------------");
        Collections.sort(list1, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : list1) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }

    @Test
    public void test2() {
        // 初始数据
        Map<String, Integer> smap = new HashMap<>();
        smap.put("1", 11);
        smap.put("3", 33);
        smap.put("2", 22);

        // 1.8使用lambda表达式
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        list2.addAll(smap.entrySet());
        Collections.sort(list2, (o1, o2) -> o2.getValue() - o1.getValue());
        list2.forEach(entry -> {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        });
    }

    public void test3() {
        // 初始数据
        Map<String, Integer> smap = new HashMap<>();
        smap.put("1", 11);
        smap.put("3", 33);
        smap.put("2", 22);
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(smap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

    }
}
