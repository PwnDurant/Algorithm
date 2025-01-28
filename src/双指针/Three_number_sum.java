package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_number_sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int min=0;
        while(min<nums.length-2){
            int left=min+1,right=nums.length-1;
            while(left<right){
                if(nums[min]>0){
                    break;
                }
                if(nums[left]+nums[right] > -nums[min]){
                    right--;
                } else if (nums[left]+nums[right] < -nums[min]) {
                    left++;
                }else{
                    List<Integer> ret=new ArrayList<>();
                    ret.add(nums[min]);
                    ret.add(nums[left]);
                    ret.add(nums[right]);
                    result.add(ret);
                    left++;
                    right--;
                    while(nums[left]==nums[left-1]&&left<right){
                        left++;
                    }
                    while(nums[right]==nums[right+1]&&left<right){
                        right--;
                    }
                }
            }
            min++;
            while(nums[min]==nums[min-1]&&min<nums.length-2) min++;
        }
        return result;
    }


    public static List<List<Integer>> threeSum_ex(int[] nums){
        List<List<Integer>> ret=new ArrayList<>();
        int n=nums.length;
//        排序
        Arrays.sort(nums);
//        利用双指针解决问题
        for(int i=0;i<n;){
//            小优化
            if(nums[i]>0) break;
            int left=i+1,right=n-1,target=-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum>target) right--;
                else if(sum<target) left++;
                else{
                    ret.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;right--;
                    while(left<right&&nums[left]==nums[left-1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                }
            }
            i++;
            while(i<n&&nums[i]==nums[i-1]) i++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums={-2,0,1,1,2};
        System.out.println(threeSum_ex(nums));
    }
}
