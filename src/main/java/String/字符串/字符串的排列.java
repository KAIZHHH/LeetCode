package String.字符串;

import java.util.*;

class 字符串的排列 {
    static List<String> res = new ArrayList();
    static Boolean isUsed[];
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet();

    public static void main(String[] args) {
        String s = "abc";
        String[] permutation = permutation(s);
        System.out.println(Arrays.toString(permutation));
    }

    public static String[] permutation(String s) {
        isUsed = new Boolean[s.length()];
        Arrays.fill(isUsed, false);
        dfs(s);
        res.addAll(set);
        Object[] o = res.toArray();
        String[] res = new String[o.length];
        for (int i = 0; i < o.length; i++) {
            String e = (String) o[i];
            res[i] = e;
        }
        return res;
    }

    public static void dfs(String s) {
        if (sb.length() == s.length()) {
            set.add(new StringBuilder(sb).toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isUsed[i] == true) continue;
//            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && isUsed[i - 1] == false) continue;
            isUsed[i] = true;
            sb.append(s.charAt(i));
            dfs(s);
            sb.delete(sb.length() - 1, sb.length());
            isUsed[i] = false;
        }
    }
}
