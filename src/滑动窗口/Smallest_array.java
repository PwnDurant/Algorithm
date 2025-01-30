package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class Smallest_array {
//    找出长度最小的字串
    public static int minSubArrayLen_ex(int target,int[] nums){
        int len=Integer.MAX_VALUE,sum=0,n=nums.length;
        for(int left=0,right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target) {
//                这是在判断过程中更新结果
                len=Math.min(len,right-left+1);
                sum -= nums[left++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }




    public static void main(String[] args) {
        int[] nums={1,4,4};
        System.out.println(minSubArrayLen_ex(1,nums));

    }

















    public static int minSubArrayLen(int target, int[] nums) {
//        List<Integer> ret=new ArrayList<>();
        int n=nums.length,sum=0,len=Integer.MAX_VALUE;
        for(int left=0,right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                len=Math.min(len,right-left+1);
                sum-=nums[left++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}
