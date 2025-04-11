package 练习.滑动窗口;

public class 将X减小到零的最小操作数 {

    public static int minOperations(int[] nums,int x){
//       先找出目标数字
        int tmp=0;
        for(int num:nums) tmp+=num;
        int target=tmp-x;
        if(target<0) return -1;
        int sum=0,len=-1;
        for(int left=0,right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){
                len=Math.max(len,right-left+1);
            }
        }
        return len==-1?-1: nums.length-len;
    }

    public static void main(String[] args) {
        int[] nums={1,1,4,2,3};
        int x=5;
        System.out.println(minOperations(nums,x));
    }
}
