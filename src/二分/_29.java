package 二分;

import java.util.HashMap;
import java.util.Map;

public class _29 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        hash.put(0,1);

        int sum=0,ret=0;
        for(int x:nums){
            sum+=x;
            ret+=hash.getOrDefault(sum-k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1};

        int k=2;
        System.out.println(subarraySum(nums, k));

    }
}
