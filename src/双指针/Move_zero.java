package 双指针;

public class Move_zero {
    public void moveZeroes(int[] nums) {
        int cur=0,dest=-1,len=nums.length;
        while(cur<len){
            if(nums[cur]==0){
                cur++;
            }else {
                dest++;
                int tmp = nums[dest];
                nums[dest] = nums[cur];
                nums[cur] = tmp;
                cur++;
            }
            }
    }
}
