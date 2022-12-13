package 笔试.深信服;

public class Main2 {

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)  return "";
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int size = Integer.MAX_VALUE;
        int count = t.length();
        int start = 0;
        while (r < s.length()) {
            if (need[s.charAt(r)] > 0) {
                count--;
            }
            need[s.charAt(r)]--;

            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;

                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;

            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
