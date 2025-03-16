package 模拟;

import java.util.HashMap;

public class 专题42 {

    public static int minNumberOfFrogs(String croakOfFrogs) {

        String tmp="croak";
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('c',0);
        hashMap.put('r',0);
        hashMap.put('o',0);
        hashMap.put('a',0);
        hashMap.put('k',0);
        char[] s=croakOfFrogs.toCharArray();
        int len=s.length;
        for(int cur=0;cur<len;cur++){
            if(s[cur]=='c'){
                if(hashMap.get('k')>0){
                    hashMap.put('k',hashMap.get('k')-1);
                    hashMap.put('c',hashMap.get('c')+1);
                }else{
                    hashMap.put('c',hashMap.get('c')+1);
                }
            }else{
                if(hashMap.get(tmp.charAt(tmp.indexOf(s[cur])-1))>0){
                    hashMap.put(tmp.charAt(tmp.indexOf(s[cur])-1),hashMap.get(tmp.charAt(tmp.indexOf(s[cur])-1))-1);
                    hashMap.put(s[cur],hashMap.get(s[cur])+1);
                }else{
                    return -1;
                }
            }
        }

        for(int i=0;i<tmp.length()-1;i++){
            if(hashMap.get(tmp.charAt(i))>0){
                return -1;
            }
        }

        return hashMap.get('k');
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroa"));
    }

}
