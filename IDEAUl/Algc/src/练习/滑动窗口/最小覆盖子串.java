package 练习.滑动窗口;

public class 最小覆盖子串 {
    public static String minWindow(String ss,String tt){
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();
        int[] hash1=new int[128];
        int kinds=0;
        for(int c:t) if(hash1[c]++==0) kinds++;
        int[] hash2=new int[128];
        int len=Integer.MAX_VALUE,begin=-1;
        for(int left=0,right=0,count=0;right<s.length;right++){
            if(++hash2[s[right]]==hash1[s[right]]) count++;
            while(count==kinds){
                if(right-left+1<len){
                    len=right-left+1;
                    begin=left;
                }
                char out=s[left++];
                if(hash2[out]--==hash1[out]) count--;
            }
        }
        if(begin==-1) return "";
        String ret=ss.substring(begin,begin+len);
        return ret;
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }
}
