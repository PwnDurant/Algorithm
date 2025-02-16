package 二分;

import java.util.HashMap;
import java.util.Map;

public class _30 {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0%k,1);
        int sum=0,ret=0;
        for(int x:nums){
            sum+=x;
            int r=(sum%k+k)%k;
            ret+=hash.getOrDefault(r,0);
            hash.put(r,hash.getOrDefault(r,0)+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={4,5,0,-2,-3,1};
        int k=5;
        System.out.println(subarraysDivByK(nums, k));

    }
}
