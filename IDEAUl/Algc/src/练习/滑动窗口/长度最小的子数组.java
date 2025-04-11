package 练习.滑动窗口;

public class 长度最小的子数组 {

    public static int minSubArrayLen(int target,int[] nums){
        int len=Integer.MAX_VALUE,n=nums.length,sum=0;
        for(int left=0,right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                len=Math.min(len,right-left+1);
                sum-=nums[left++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));
    }
}
