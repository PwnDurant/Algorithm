package 滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_anagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret=new ArrayList<>();
//        目标字符串的长度
        int n=p.length();
        if(n>s.length()){
            return ret;
        }
//        这是目标字符串的哈希表
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
        }
        //        这是用于判断字符串的哈希表
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
        }
        for(int left=0,right=n-1;right<s.length();){
            if(map2.equals(map1)){
                ret.add(left);
                map2.put(s.charAt(left),map2.get(s.charAt(left))-1);
                if(map2.get(s.charAt(left))==0) map2.remove(s.charAt(left));
                left++;
            }else{
                map2.put(s.charAt(left),map2.get(s.charAt(left))-1);
                if(map2.get(s.charAt(left))==0) map2.remove(s.charAt(left));
                left++;
            }
            right++;
            if(right<s.length()){
                map2.put(s.charAt(right),map2.getOrDefault(s.charAt(right),0)+1);
            }
        }
        return ret;
    }

    public static List<Integer> findAnagrams_ex(String ss, String pp){
        List<Integer> ret=new ArrayList<>();
//        把字符串转换为字符数组
        char[] s=ss.toCharArray();
        char[] p=pp.toCharArray();
//        统计字符串p中每一个字符出现的次数
        int[] hash1=new int[26];
        for(char ch:p) hash1[ch-'a']++;
//        统计窗口中每一个字符出现的个数
        int[] hash2=new int[26];
        int m=p.length;
//        count就是有效字符串
        for(int left=0,right=0,count=0;right<s.length;right++){
            char in=s[right];
//            进窗口，维护count
            if(++hash2[in-'a']<=hash1[in-'a']) count++;
            if(right-left+1>m){
                char out=s[left++];
//                 出窗口，维护count
                if(hash2[out-'a']--<=hash1[out-'a']) count--;
            }
//            更新结果
            if(count==m) ret.add(left);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s="aaaaaaaaaa";
        System.out.println(findAnagrams(s,"aaaaaaaaaaaaa"));
    }
}
