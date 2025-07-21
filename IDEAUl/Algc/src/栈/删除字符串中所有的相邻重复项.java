package 栈;

/**
 * <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/">题目链接</a>
 */
public class 删除字符串中所有的相邻重复项 {

    public static String removeDuplicates(String _s) {
        StringBuffer ret = new StringBuffer();
        char[] s = _s.toCharArray();
        for (char c : s) {
            if(ret.length() > 0 && c == ret.charAt(ret.length() - 1))
                ret.deleteCharAt(ret.length() - 1);
            else ret.append(c);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String test = "abbaca";
        System.out.println(removeDuplicates(test));
    }

}
