package 滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_covering_substring {
    public static boolean check(Map<Character,Integer> hash1,Map<Character,Integer> hash2,char[] t){
        boolean flag=true;
        for(char ch:t){
            if(hash2.getOrDefault(ch,0)<hash1.get(ch))
                flag=false;
        }
        return flag;
    }

    public static String minWindow(String ss, String tt) {
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();
        if(t.length>s.length)
            return "";

        List<String> ret=new ArrayList<>();

        Map<Character,Integer> hash1=new HashMap<>();
        for(char c:t) hash1.put(c,hash1.getOrDefault(c,0)+1);

        Map<Character,Integer> hash2=new HashMap<>();
        for(int left=0,right=0;right<s.length;right++){
            hash2.put(s[right],hash2.getOrDefault(s[right],0)+1);
            while(check(hash1,hash2,t)){
                ret.add(ss.substring(left,right+1));
                hash2.put(s[left],hash2.getOrDefault(s[left],0)-1);
                if(hash2.get(s[left])==0) hash2.remove(s[left]);
                left++;
            }
        }
        if(ret.size()>0){
            String tmp=ret.get(0);
            for(int i=0;i<ret.size();i++){
                if(ret.get(i).length()<tmp.length())
                    tmp=ret.get(i);
            }
            return tmp;
        }
        return "";
    }

    public static String minWindow_lasted(String ss,String tt){
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();


//        List<String> ret=new ArrayList<>();

        int[] hash1=new int[128];
        int kinds=0;
        for(int c:t) {
            if(hash1[c]++==0) kinds++;
        }

        int[] hash2=new int[128];
        int len=Integer.MAX_VALUE,begin=-1;
        for(int left=0,right=0,count=0;right<s.length;right++){
            if(++hash2[s[right]]==hash1[s[right]]) count++;
            while(count==kinds){
//                ret.add(ss.substring(left,right+1));
                if(right-left+1<len){
                    len=right-left+1;
                    begin=left;
                }
                char out=s[left++];
                if(hash2[out]--==hash1[out]) count--;
            }
        }
        if(begin==-1){
            return "";
        }
        String ret=ss.substring(begin,begin+len);
//        if(!ret.isEmpty()){
//            String tmp=ret.get(0);
//            for (String string : ret) {
//                if (string.length() < tmp.length())
//                    tmp = string;
//            }
//            return tmp;
//        }
//        return "";
//        return ret;
        return ret;
    }



    public static String minWindow_lasted_ex(String ss,String tt){
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();

        List<String> ret=new ArrayList<>();

        int[] hash1=new int[128];
        int kinds=0;
        for(int c:t) {
            if(hash1[c]++==0) kinds++;
        }

        int[] hash2=new int[128];
        for(int left=0,right=0,count=0,len=0;right<s.length;right++){
            if(++hash2[s[right]]==hash1[s[right]]) count++;
            while(count==kinds){
                ret.add(ss.substring(left,right+1));
                if(hash2[s[left]]--==hash1[s[left]]) count--;
                left++;
            }
        }
        if(!ret.isEmpty()){
            String tmp=ret.get(0);
            for (String string : ret) {
                if (string.length() < tmp.length())
                    tmp = string;
            }
            return tmp;
        }
        return "";
//        return ret;
    }


    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow_lasted(s,t));
    }
}
