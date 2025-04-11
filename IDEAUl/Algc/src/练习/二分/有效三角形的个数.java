package 练习.二分;

import java.util.Arrays;

public class 有效三角形的个数 {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int max=nums.length-1;max>=2;max--){
            int left=0,right=max-1;
            while (left<right){
                if(nums[left]+nums[right]>nums[max]){
                    count+=right-left;
                    right--;
                }else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num={2,2,3,4};
        System.out.println(triangleNumber(num));
    }

}
