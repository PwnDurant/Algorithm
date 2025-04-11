package 练习.二分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int min=0;
        while(min<nums.length-2){
            int left=min+1,right=nums.length-1;
            while(left<right){
                if(nums[min]>0){
                    break;}
                if(nums[left]+nums[right]> -nums[min]){
                    right--;
                }else if(nums[left]+nums[right]< -nums[min]) {
                    left++;
                }else{
                    List<Integer> ret=new ArrayList<>();
                    ret.add(nums[min]);
                    ret.add(nums[left]);
                    ret.add(nums[right]);
                    result.add(ret);
                    left++;
                    right--;
                    while(nums[left]==nums[left-1]&&left<right) left++;
                    while(nums[right]==nums[right+1]&&left<right) right--;
                }
            }
            min++;
            while(nums[min]==nums[min-1]&&min< nums.length-2) min++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[]  nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
