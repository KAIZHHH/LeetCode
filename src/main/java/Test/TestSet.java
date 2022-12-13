package Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/9/5 下午12:53
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("AA");
        set.add("BB");
        set.add(new String("BB"));
        for (String str :
                set) {
            System.out.println(str);

        }
    }
}
