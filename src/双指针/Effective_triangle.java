package 双指针;

import java.util.Arrays;

public class Effective_triangle {
    public static int triangleNumber(int[] nums) {
//        这里在判断三角形的时候有一个结论：
//        如果三个数的两个最小的数的和都大于第三个数，说明这组数是肯定能构成三角形的，因此可以先把数组排序，然后直接取前两个数就行
        Arrays.sort(nums);
        int count=0;
        for(int max=nums.length-1;max>=2;max--){
            int left=0,right=max-1;
//            两指针相向移动，如果小了就增大左边的，如果大了就先想数据存一下然后再减少右边的
            while(left<right){
                if(nums[left]+nums[right]>nums[max]) {
                    count+=right-left;
                    right--;
                }
                else left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
