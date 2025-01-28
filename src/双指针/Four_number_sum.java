package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_number_sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int min1=0;min1<nums.length-3;){
            for(int min2=min1+1;min2<nums.length-2;){
                int left=min2+1,right=nums.length-1;
                while(left<right){
                    long aim=(long)target-nums[min1]-nums[min2];
                    if(nums[left]+nums[right]>aim){
                        right--;
                    } else if (nums[left]+nums[right]<aim) {
                        left++;
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
            while(nums[min1]==nums[min1-1]&&min1<nums.length-3) min1++;
        }
        return result;
    }


    public static List<List<Integer>> fourSum_ex(int[] nums, int target){
        List<List<Integer>> ret=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;){
            for(int j=i+1;j<n;){
                int left=j+1,right=n-1;
                long aim=(long)target-nums[left]-nums[right];
                while(left<right){
                    int sum=nums[left]+nums[right];
                    if(sum>aim) right--;
                    else if(sum<aim) left++;
                    else{
                        ret.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[left],nums[right])));
                        while(left<right&&nums[left]==nums[left-1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;
                    }
                }
                j++;
                while(j<n&&nums[j]==nums[j-1]) j++;
            }
            i++;
            while(i<n&&nums[i]==nums[i-1]) i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum_ex(nums,-294967296));
    }
}
