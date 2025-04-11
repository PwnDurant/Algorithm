package 滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Concatenate_all_the_substrings {






    public static String[] splitStringByLength(String str, int length) {
        if (str == null || length <= 0) {
            throw new IllegalArgumentException("输入无效");
        }

        List<String> result = new ArrayList<>();
        int strLength = str.length();

        for (int i = 0; i < strLength; i += length) {
            int end = Math.min(i + length, strLength);
            result.add(str.substring(i, end));
        }

        return result.toArray(new String[0]);
    }




    public static String[] subString(String s,int length){
        int num=s.length()/length;
        String[] ret=new String[num];
        for(int i=0,j=0;i<s.length();i+=length){
            int end=i+length;
            ret[j]=s.substring(i,end);
            j++;
        }
        return ret;
    }
    public static List<Integer> findSubstring(String ss, String[] words) {
        List<Integer> ret=new ArrayList<>();
        String[] s=subString(ss,words[0].length());
        for(String t:s){
            System.out.println(t);
        }
        int n= words.length;
        if(n>s.length) return ret;

        Map<String,Integer> map1=new HashMap<>();
        for(int i=0;i<n;i++)
            map1.put(words[i],map1.getOrDefault(words[i],0)+1);

        Map<String,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++)
            map2.put(s[i],map2.getOrDefault(s[i],0)+1);

        for(int left=0,right=n-1;right<s.length;){
            if(map2.equals(map1)){
                ret.add(left*words[0].length());
                map2.put(s[left],map2.get(s[left])-1);
                if(map2.get(s[left])==0) map2.remove(s[left]);
                left++;
            }else{
                map2.put(s[left],map2.get(s[left])-1);
                if(map2.get(s[left])==0) map2.remove(s[left]);
                left++;
            }
            right++;
            if(right<s.length){
                map2.put(s[right],map2.getOrDefault(s[right],0)+1);
            }
        }
        return ret;
    }

    public static List<Integer> findSubstring_ex(String ss, String[] words){
        List<Integer> ret=new ArrayList<Integer>();
        Map<String,Integer> hash1=new HashMap<>();
        for(String str:words) hash1.put(str,hash1.getOrDefault(str,0)+1);

        int len=words[0].length(),m= words.length;
        for(int i=0;i<len;i++){
            Map<String,Integer> hash2=new HashMap<>();
            for(int left=i,right=i,count=0;right+len<ss.length();right+=len){
                String in=ss.substring(right,right+len);
                System.out.println(in);
                hash2.put(in,hash2.getOrDefault(in,0)+1);
                if(hash2.get(in)<=hash1.getOrDefault(in,0)) count++;

                if(right-left+1>len*m){
                    String out=ss.substring(left,left+len);
                    if(hash2.get(out)<=hash1.getOrDefault(out,0)) count--;
                    hash2.put(out,hash2.get(out)-1);
                    left+=len;
                }
                if(count==m) ret.add(left);
            }
        }
        return ret;
    }

    public static List<Integer> findSubstring_lasted(String ss, String[] words){
        List<Integer> ret=new ArrayList<>();
        int n=words[0].length();
        int m= words.length;

        Map<String,Integer> hash1=new HashMap<>();
        for(String tmp:words) hash1.put(tmp,hash1.getOrDefault(tmp,0)+1);

        for(int i=0;i<n;i++){
            Map<String,Integer> hash2=new HashMap<>();
            for(int left=i,right=i;right+n<=ss.length();right+=n){
//                if(right<=ss.length()-n&&left<=right){
                    String in=ss.substring(right,right+n);
                    hash2.put(in,hash2.getOrDefault(in,0)+1);
                    if(hash2.equals(hash1)){
                        ret.add(left);
                        String out=ss.substring(left,left+n);
                        hash2.put(out,hash2.get(out)-1);
                        if(hash2.get(out)==0) hash2.remove(out);
                        left+=n;
                    }
                    if(right-left+n==n*m){
                        String out=ss.substring(left,left+n);
                        hash2.put(out,hash2.get(out)-1);
                        if(hash2.get(out)==0) hash2.remove(out);
                        left+=n;
                    }
                }
            }
//        }
        return ret;
    }

    public static void main(String[] args) {
        String s="wordgoodgoodgoodbestword";
//        System.out.println(s1);
//        words中所有字符串的长度都相同
        String[] words={"word","good","best","word"};
        System.out.println(findSubstring_lasted(s,words));
//        String[] test=subString(s,3);
//        for(String t:test){
//            System.out.println(t);
//        }

    }
}
