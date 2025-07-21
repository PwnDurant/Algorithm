package 哈希表;

/**
 * <a href="https://leetcode.cn/problems/check-permutation-lcci/description/">题目链接</a>
 */
public class 判断是否互为字符重排 {

    // 使用 HashMap
//    public static boolean CheckPermutationOld(String s1, String s2) {
//
//    }
//
//    // 使用数组
//    public static boolean CheckPermutationNew(String s1, String s2) {
//
//    }

    // 使用一个数组
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int i1 = hash[s2.charAt(i) - 'a'];
            i1--;
            if(i1 <0 ) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "baca";
        System.out.println(CheckPermutation(s1,s2));
    }

}
