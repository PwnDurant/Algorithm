package 练习.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret=new ArrayList<>();
        int n=p.length();
        if(n>s.length()){
            return ret;
        }

//        目标字符串的哈希表
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
        }
        //        目标字符串的哈希表
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
        }

//        开始比较
        for(int left=0,right=n-1;right<s.length();){

            if(map1.equals(map2)){
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

    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        System.out.println(findAnagrams(s,p));
    }
}
