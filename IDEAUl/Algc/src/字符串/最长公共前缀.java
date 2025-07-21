package 字符串;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/">题目链接</a>
 */
public class 最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return new String(result);
            }
            result.append(strs[0].charAt(i));
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String[] strs = {"ab","a"};
        System.out.println(longestCommonPrefix(strs));

    }

}
