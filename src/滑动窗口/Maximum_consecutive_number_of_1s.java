package 滑动窗口;

public class Maximum_consecutive_number_of_1s {
    public static int longestOnes(int[] nums,int k){
        int len=0,left=0,right=0;
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
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
    }
}
