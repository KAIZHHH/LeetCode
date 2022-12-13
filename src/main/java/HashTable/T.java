package HashTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author kai
 * @date 2022/1/22 下午3:43
 */
class Emp {
    String name;
    int age;

    public Emp() {
    }

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class T {
    public static void main(String[] args) {

        Map<Integer, Object> map = new HashMap();
        map.put(1, new Emp("zhk", 20));
        map.put(2, new Emp("zhkk", 20));

        //第一种遍历、entrySet效率高
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            Emp emp = (Emp) next.getValue();
            if (emp.getAge() >= 20) {
                System.out.println(emp);
            }
        }

        //第二种遍历、keySet代码简洁
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Emp emp = (Emp) map.get(key);
            if (emp.getAge() >= 20) {
                System.out.println(emp);
            }
        }

    }
}
