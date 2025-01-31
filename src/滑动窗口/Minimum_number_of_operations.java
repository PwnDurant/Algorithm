package 滑动窗口;

public class Minimum_number_of_operations {
    public static int minOperations(int[] nums, int x) {
        int sum=0;
        for(int a:nums) sum+=a;
        int target =sum-x;
        if(target<0) return -1;
        int ret=-1;
        for(int left=0,right=0,tmp=0;right<nums.length;right++){
            tmp+=nums[right];
            while(tmp>target){
                tmp-=nums[left++];
            }
            if(tmp==target) ret=Math.max(ret,right-left+1);
        }
        if(ret==-1) return ret;
        else return nums.length-ret;

    }

    public static void main(String[] args) {
        int[] nums={1,1,4,2,3};
        System.out.println(minOperations(nums,5));
    }
}
