package 滑动窗口;

public class No_duplicate_longest_substring {
//    public static int sum(int[] count){
//        int ret=0;
//        for(int tmp:count){
//            ret+=tmp;
//        }
//        return ret;
//    }
    public static int lengthOfLongestSubstring(String s) {
//        无重复子串
        int[] count=new int[128];
        int left=0,right=0,len=0;
//        这里不可以用s.charAt(right)!='\0'，java中'\0'是不起作用的，charAt只会返回字符串中存在的字符
        while(right<s.length()){
            count[s.charAt(right)]++;
            while(count[s.charAt(right)]>1){
                count[s.charAt(left++)]--;
            }
//            这里的len要判断完之后再更新结果
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }

    public static void print(int[] count){
        for(int num:count){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        String s="bbbbbb";
//        System.out.println(s.length());
        System.out.println(lengthOfLongestSubstring(s));
//        int[] count=new int[26];
//        print(count);
    }

}
