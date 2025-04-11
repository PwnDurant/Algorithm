package 练习.二分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int min1=0;min1<nums.length-3;){
            for(int min2=min1+1;min2<nums.length-2;){
                int left=min2+1,right=nums.length-1;
                long aim=(long)target-nums[min1]-nums[min2];
                while(left<right){
                    if(nums[left]+nums[right] < aim){
                        left++;
                    }else if (nums[left]+nums[right] > aim){
                        right--;
                    }else{
                        result.add(new ArrayList<>(Arrays.asList(nums[min1],nums[min2],nums[left],nums[right])));
                        left++;
                        right--;
                        while(nums[left]==nums[left-1]&&left<right) left++;
                        while(nums[right]==nums[right+1]&&left<right) right--;
                    }
                }
                min2++;
                while(nums[min2]==nums[min2-1]&&min2<nums.length-2) min2++;
            }
            min1++;
            while(nums[min1]==nums[min1-1]&&min1<nums.length-2) min1++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(nums,target));
    }

}
