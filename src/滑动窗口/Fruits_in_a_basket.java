package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class Fruits_in_a_basket {

//    用数组模拟哈希
    public static int totalFruits_ex(int[] fruits){
        int kinds=0,ret=0;
        int[] hash=new int[fruits.length];
        for(int left=0,right=0;right<fruits.length;right++){
            int in=fruits[right];
            if(hash[in]==0) kinds++;
            hash[in]++;
            while(kinds>2){
                int out=fruits[left];
                hash[out]--;
                if(hash[out]==0) kinds--;
                left++;
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }


    public static int totalFruit(int[] fruits){
//        统计窗口内水果的种类
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        int ret=0;
        for(int left=0,right=0;right<fruits.length;right++){
            int in=fruits[right];
//            进窗口
            hash.put(in,hash.getOrDefault(in,0)+1);
            while(hash.size()>2){
                int out=fruits[left];
                hash.put(out,hash.get(out)-1);
                if(hash.get(out)==0)
                    hash.remove(out);
                left++;
            }
            //                 更新结果
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruits_ex(nums));
    }
}
