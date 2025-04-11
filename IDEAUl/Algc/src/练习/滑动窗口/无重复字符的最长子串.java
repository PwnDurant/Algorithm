package 练习.滑动窗口;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        int[] count=new int[128];
        int len=0,right=0,left=0;
        while(right<s.length()){
            count[s.charAt(right)]++;
            while(count[s.charAt(right)]>1){
                count[s.charAt(left++)]--;
            }
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
