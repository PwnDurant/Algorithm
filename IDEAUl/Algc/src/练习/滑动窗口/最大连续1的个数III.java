package 练习.滑动窗口;

public class 最大连续1的个数III {

    public static int longestOnes(int[] nums,int k){
        int right=0,left=0,len=0;
        while(right<nums.length){
            if(nums[right]==0){
                k--;
            }
            while(k<0){
                if(nums[left]==0){
                    k++;
                    left++;
                }else{
                    left++;
                }
            }
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int K=2;
        System.out.println(longestOnes(nums,K));
    }

}
