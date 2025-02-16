package 二分;

import java.util.HashMap;
import java.util.Map;

public class _31 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0,-1);
        int sum=0,ret=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==0?-1:1);
            if(hash.containsKey(sum)) ret=Math.max(ret,i-hash.get(sum));
            else hash.put(sum,i);
        }
        return ret;
    }

}
