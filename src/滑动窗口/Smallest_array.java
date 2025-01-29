package 滑动窗口;

public class Smallest_array {
    public int minSubArrayLen(int target, int[] nums) {
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

    public static void main(String[] args) {
        
    }
}
