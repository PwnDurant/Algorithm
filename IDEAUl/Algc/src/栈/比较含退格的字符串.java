package 栈;

/**
 * <a href="https://leetcode.cn/problems/backspace-string-compare/">题目链接</a>
 */
public class 比较含退格的字符串 {

    public static boolean backspaceCompare(String s, String t) {
        System.out.println(prototype(s));
        System.out.println(prototype(t));
        return prototype(s).equals(prototype(t));
    }

    private static String prototype(String _s) {
        StringBuilder ret = new StringBuilder();
        char[] s = _s.toCharArray();
        for (char c : s) {
            if(c == '#') {
                if(ret.isEmpty()) continue;
                else ret.deleteCharAt(ret.length() - 1);
            }
            else ret.append(c);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s,t));
    }
}
