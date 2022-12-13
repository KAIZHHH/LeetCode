package Test.String;

/**
 * @author kai
 * @date 2022/9/5 下午2:20
 */
public class T2 {
    private static int i = 0;

    public static void main(String[] args) {
        T2 t1 = new T2();
        T2 t2 = new T2();
        t1.add();
        t2.add();
        T2.add();
        System.out.println(t1.i + " " + t2.i + " " + T2.i);
    }

    private static void add() {
        i++;
    }
}
