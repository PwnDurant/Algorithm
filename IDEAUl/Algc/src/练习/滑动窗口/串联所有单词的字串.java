package 练习.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联所有单词的字串 {
    public static List<Integer> findSubstring(String ss, String[] words){
        List<Integer> ret=new ArrayList<>();
        int n=words[0].length();
        int m= words.length;

        Map<String,Integer> map1=new HashMap<>();
        for(String tmp:words) map1.put(tmp,map1.getOrDefault(tmp,0)+1);

        for(int i=0;i<n;i++){
            Map<String,Integer> map2=new HashMap<>();
            for(int left=i,right=i;right+n<=ss.length();right+=n){
                String in=ss.substring(right,right+n);
                map2.put(in,map2.getOrDefault(in,0)+1);
                if(map1.equals(map2)){
                    ret.add(left);
                    String out=ss.substring(left,left+n);
                    map2.put(out,map2.get(out)-1);
                    if(map2.get(out)==0) map2.remove(out);
                    left+=n;
                }
                if(right-left+n==n*m){
                    String out=ss.substring(left,left+n);
                    map2.put(out,map2.get(out)-1);
                    if(map2.get(out)==0) map2.remove(out);
                    left+=n;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String ss="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};
        System.out.println(findSubstring(ss,words));
    }
}
