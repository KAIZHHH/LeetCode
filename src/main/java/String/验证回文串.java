package String;


/*
static boolean isLetterOrDigit(char ch)判断字符是不是字母或数字
static boolean isLetter(char ch)判断字符是不是字母
static boolean isDigit(char ch)判断字符是不是数字
 */
class 验证回文串 {
    public static void main(String[] args) {
        boolean abda = isPalindrome("a,.bba=");
        System.out.println(abda);
    }

    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {//isLetterOrDigit()排除标点符号
                c = Character.toLowerCase(c);//toLowerCase()把字符串转换为小写
                sb.append(c);
            }
        }
        if (isValid(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid(String str) {
        int l = 0;
        int r = str.length()-1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
